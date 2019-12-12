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

import com.db1start.cidadesapi.adapter.CidadeAdapter;
import com.db1start.cidadesapi.dto.CidadeDTO;
import com.db1start.cidadesapi.dto.CidadeFormDTO;
import com.db1start.cidadesapi.service.CidadeService;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	// CRIAR

	@PostMapping("/criar")
	public CidadeDTO criarCidade(@RequestBody CidadeFormDTO cidadeForm) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.criarCidade(cidadeForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<CidadeDTO> buscarTodosCidades() {
		return CidadeAdapter.listaDeCidadeParaDTO(cidadeService.buscarTodas());
	}

	@GetMapping("/buscarporid/{id}")
	public CidadeDTO buscarCidadePorId(@PathVariable(value = "id") Long id) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.buscarCidadePorId(id));
	}

	@GetMapping("/buscarpornome/{nome}")
	public CidadeDTO buscarCidadePorNome(@PathVariable(value = "nome") String nome) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.buscarCidadePorNome(nome));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasCidades() {
		cidadeService.limparCidades();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarCidadePorId(@PathVariable(value = "id") Long id) {
		cidadeService.excluirCidadePorId(id);
	}

	// ATUALIZAR

	@PutMapping("/atualizar/{id}")
	public CidadeDTO atualizar(@PathVariable(value = "id") Long id, @RequestBody CidadeFormDTO cidadeForm) {
		return CidadeAdapter.cidadeParaDTO(cidadeService.atualizar(id, cidadeForm));
	}
}
