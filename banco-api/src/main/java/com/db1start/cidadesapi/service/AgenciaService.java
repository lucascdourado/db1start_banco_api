package com.db1start.cidadesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.AgenciaFormDTO;
import com.db1start.cidadesapi.repository.AgenciaRepository;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private CidadeService cidadeService;

	public Agencia criarAg(String numeroAg, String numeroBanco, Cidade cidade) {
		Agencia agencia = new Agencia(numeroAg, numeroBanco, cidade);
		return agenciaRepository.save(agencia);
	}

	public Agencia criarAg(AgenciaFormDTO agenciaForm) {
		Cidade cidade = cidadeService.buscarCidadePorId(agenciaForm.getIdCidade());
		Agencia agencia = new Agencia(agenciaForm.getNumeroAg(), agenciaForm.getNumeroBanco(), cidade);
		return agenciaRepository.save(agencia);
	}

	public List<Agencia> buscarTodasAg() {
		return agenciaRepository.findAll();
	}

	public Agencia bucarAgPorNumero(String numeroAg) {
		return agenciaRepository.findByNumeroAg(numeroAg)
				.orElseThrow(() -> new RuntimeException("Agência nº" + numeroAg + " não encontrada"));
	}

	public Agencia buscarAgPorId(Long id) {
		return agenciaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agência com ID: " + id + " não encontrada"));
	}

	public List<Agencia> buscarTodasAgenciasEmUmaCidade(Cidade cidade) {
		List<Agencia> agencias = new ArrayList<>();
		for (Agencia agencia : buscarTodasAg()) {
			if (agencia.getCidade().equals(cidade)) {
				agencias.add(agencia);
			}
		}
		return agencias;
	}

	public void excluirAgPorId(Long id) {
		agenciaRepository.deleteById(id);
	}

	public void limparAgs() {
		agenciaRepository.deleteAll();
	}

	public Agencia atualizar(Long id, AgenciaFormDTO agenciaForm) {
		Agencia agencia = buscarAgPorId(id);
		agencia.setNumeroAg(agenciaForm.getNumeroAg());
		agencia.setNumeroBanco(agenciaForm.getNumeroBanco());
		agencia.setCidade(cidadeService.buscarCidadePorId(agenciaForm.getIdCidade()));
		return agenciaRepository.save(agencia);
	}
}
