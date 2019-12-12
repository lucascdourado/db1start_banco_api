package com.db1start.cidadesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db1start.cidadesapi.adapter.ContaAdapter;
import com.db1start.cidadesapi.dto.ContaDTO;
import com.db1start.cidadesapi.dto.ContaFormDTO;
import com.db1start.cidadesapi.dto.OperacoesFormDTO;
import com.db1start.cidadesapi.service.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	// CRIAR

	@PostMapping("/criar")
	public ContaDTO criarConta(@RequestBody ContaFormDTO contaForm) {
		return ContaAdapter.contaParaDTO(contaService.criarConta(contaForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<ContaDTO> buscarTodasContas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContas());
	}

	@GetMapping("/buscartodasativas")
	public List<ContaDTO> buscarTodasContasAtivas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasAtivas());
	}

	@GetMapping("/buscartodasinativas")
	public List<ContaDTO> buscarTodasContasInativas() {
		return ContaAdapter.listaDeContasParaDTO(contaService.buscaTodasContasInativas());
	}

	@GetMapping("/buscarporid/{id}")
	public ContaDTO buscarContaPorId(@PathVariable(value = "id") Long id) {
		return ContaAdapter.contaParaDTO(contaService.buscarContaPorId(id));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasContas() {
		contaService.limparContas();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarContaPorId(@PathVariable(value = "id") Long id) {
		contaService.excluirContaPorId(id);
	}

	// OPERACOES

	@PostMapping("/depositar")
	public ContaDTO depositar(@RequestBody OperacoesFormDTO operacaoForm) {
		return ContaAdapter.contaParaDTO(contaService.depositar(operacaoForm));
	}

	@PostMapping("/sacar")
	public ContaDTO sacar(@RequestBody OperacoesFormDTO operacaoForm) {
		return ContaAdapter.contaParaDTO(contaService.sacar(operacaoForm));
	}

	@GetMapping("/ativar/{id}")
	public void ativarConta(@PathVariable(value = "id") Long id) {
		contaService.ativar(id);
	}

	@GetMapping("/desativar/{id}")
	public void desativarConta(@PathVariable(value = "id") Long id) {
		contaService.desativar(id);
	}

	// ATUALIZAR

	@PutMapping("/atualizar{id}")
	public ContaDTO atualizar(@PathVariable(value = "id") Long id, @RequestBody ContaFormDTO contaForm) {
		return ContaAdapter.contaParaDTO(contaService.atualizar(id, contaForm));
	}
}