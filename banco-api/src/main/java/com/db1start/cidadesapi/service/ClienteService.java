package com.db1start.cidadesapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.dto.ClienteFormDTO;
import com.db1start.cidadesapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente criarCliente(String nome, String cpf) {
		Cliente cliente = new Cliente(nome, cpf);
		return clienteRepository.save(cliente);
	}

	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorNome(String nome) {
		return clienteRepository.findByNome(nome)
				.orElseThrow(() -> new RuntimeException("cliente " + nome + " não encontrado"));
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("cliente com id " + id + " não encontrado"));
	}

	public void excluirClientePorId(Long id) {
		clienteRepository.deleteById(id);
	}

	public void limparClientes() {
		clienteRepository.deleteAll();
	}

	public Cliente atualizar(Long id, ClienteFormDTO clienteForm) {
		Cliente cliente = buscarClientePorId(id);
		cliente.setNome(clienteForm.getNome());
		cliente.setCpf(clienteForm.getCpf());
		return clienteRepository.save(cliente);
	}
}
