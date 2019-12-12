package com.db1start.cidadesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.CidadeFormDTO;
import com.db1start.cidadesapi.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoService estadoService;

	public Cidade criarCidade(String nome, Estado uf) {
		Cidade cidade = new Cidade(nome, uf);
		return cidadeRepository.save(cidade);
	}

	public Cidade criarCidade(CidadeFormDTO cidadeForm) {
		Estado uf = estadoService.buscarPorId(cidadeForm.getUf());
		Cidade cidade = new Cidade(cidadeForm.getNome(), uf);
		return cidadeRepository.save(cidade);
	}

	public Cidade buscarCidadePorNome(String nome) {
		return cidadeRepository.findByNome(nome)
				.orElseThrow(() -> new RuntimeException("cidade de " + nome + " não encontrada"));
	}

	public Cidade buscarCidadePorId(Long id) {
		return cidadeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("cidade com id " + id + " não encontrada"));
	}

	public List<Cidade> buscarTodas() {
		return cidadeRepository.findAll();
	}

	public List<Cidade> buscarTodasCidadesEmUmEstado(Estado estado) {
		List<Cidade> cidades = new ArrayList<>();
		for (Cidade cidade : buscarTodas()) {
			if (cidade.getUf().equals(estado)) {
				cidades.add(cidade);
			}
		}
		return cidades;
	}

	public Cidade atualizar(Long id, String novoNome, Estado uf) {
		Cidade cidade = buscarCidadePorId(id);
		cidade.setNome(novoNome);
		return cidadeRepository.save(cidade);
	}

	public Cidade atualizar(Long id, CidadeFormDTO cidadeForm) {
		Cidade cidade = buscarCidadePorId(id);
		cidade.setNome(cidadeForm.getNome());
		cidade.setUf(estadoService.buscarPorId(cidadeForm.getUf()));
		return cidadeRepository.save(cidade);
	}

	public void excluirCidadePorId(Long id) {
		cidadeRepository.deleteById(id);
	}

	public void limparCidades() {
		cidadeRepository.deleteAll();
	}
}
