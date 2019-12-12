package com.db1start.cidadesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.EstadoFormDTO;
import com.db1start.cidadesapi.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criarEstado(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public Estado buscarPorNome(String nome) {
		return estadoRepository.findByNome(nome)
				.orElseThrow(() -> new RuntimeException("estado " + nome + " não encontrado"));
	}

	public Estado buscarPorId(Long id) {
		return estadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("estado com id " + id + " nao encontrado no banco de dados."));
	}

	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}

	public Estado atualizar(Long id, String novoNome) {
		Estado estado = buscarPorId(id);
		estado.setNome(novoNome);
		return estadoRepository.save(estado);
	}

	public Estado atualizarEstadoPorId(Long id, EstadoFormDTO estadoForm) {
		Estado estado = buscarPorId(id);
		estado.setNome(estadoForm.getNome());
		return estadoRepository.save(estado);
	}

	public void excluirEstadoPorId(Long id) {
		estadoRepository.deleteById(id);
	}

	public void limparEstados() {
		estadoRepository.deleteAll();
	}
}
