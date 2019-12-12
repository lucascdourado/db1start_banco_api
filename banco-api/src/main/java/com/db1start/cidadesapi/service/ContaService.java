package com.db1start.cidadesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.domain.entity.StatusConta;
import com.db1start.cidadesapi.dto.ContaFormDTO;
import com.db1start.cidadesapi.dto.OperacoesFormDTO;
import com.db1start.cidadesapi.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	public Conta criarConta(ContaFormDTO contaForm) {
		Cliente cliente = clienteService.buscarClientePorId(contaForm.getIdCliente());
		Agencia agencia = agenciaService.buscarAgPorId(contaForm.getIdAgencia());
		Conta conta = new Conta(cliente, agencia);
		return contaRepository.save(conta);
	}

	public Conta criarConta(Cliente cliente, Agencia agencia) {
		Conta conta = new Conta(cliente, agencia);
		return contaRepository.save(conta);
	}

	// BUSCAR

	public List<Conta> buscaTodasContas() {
		return contaRepository.findAll();
	}

	public Conta buscarContaPorId(Long id) {
		return contaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Conta com id " + id + " nao encontrada no banco de dados."));
	}

	public List<Conta> buscaTodasContasAtivas() {
		List<Conta> ativas = new ArrayList<>();
		for (Conta conta : contaRepository.findAll()) {
			if (conta.getStatus() == StatusConta.ATIVA) {
				ativas.add(conta);
			}
		}
		return ativas;
	}

	public List<Conta> buscaTodasContasInativas() {
		List<Conta> inativas = new ArrayList<>();
		for (Conta conta : buscaTodasContas()) {
			if (conta.getStatus() == StatusConta.INATIVA) {
				inativas.add(conta);
			}
		}
		return inativas;
	}

	// APAGAR

	public void limparContas() {
		contaRepository.deleteAll();
	}

	public void excluirContaPorId(Long id) {
		contaRepository.deleteById(id);
	}

	// ATUALIZAR

	public Conta atualizar(Long id, ContaFormDTO contaForm) {
		Conta conta = buscarContaPorId(id);
		conta.setCliente(clienteService.buscarClientePorId(contaForm.getIdCliente()));
		conta.setAgencia(agenciaService.buscarAgPorId(contaForm.getIdAgencia()));
		return contaRepository.save(conta);
	}

	// OPERACOES

	public Conta depositar(OperacoesFormDTO operacaoForm) {
		Conta conta = buscarContaPorId(operacaoForm.getIdConta());
		conta.depositar(operacaoForm.getValor());
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta depositar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.depositar(valor);
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta sacar(OperacoesFormDTO operacaoForm) {
		Conta conta = buscarContaPorId(operacaoForm.getIdConta());
		conta.sacar(operacaoForm.getValor());
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta sacar(Long idConta, Double valor) {
		Conta conta = buscarContaPorId(idConta);
		conta.sacar(valor);
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta ativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.ativar();
		return contaRepository.save(conta); // Devolve a conta atualizada
	}

	public Conta desativar(Long idConta) {
		Conta conta = buscarContaPorId(idConta);
		conta.desativar();
		return contaRepository.save(conta); // Devolve a conta atualizada
	}
}
