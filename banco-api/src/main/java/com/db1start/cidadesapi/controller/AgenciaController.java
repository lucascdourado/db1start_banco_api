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

import com.db1start.cidadesapi.adapter.AgenciaAdapter;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.AgenciaFormDTO;
import com.db1start.cidadesapi.service.AgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {

	@Autowired
	private AgenciaService agenciaService;

	// CRIAR

	@PostMapping("/criar")
	public AgenciaDTO criarAgencia(@RequestBody AgenciaFormDTO agenciaForm) {
		return AgenciaAdapter.agParaDTO(agenciaService.criarAg(agenciaForm));
	}

	// BUSCAR

	@GetMapping("/buscartodas")
	public List<AgenciaDTO> buscarTodosAgencias() {
		return AgenciaAdapter.listaDeAgenciasParaDTO(agenciaService.buscarTodasAg());
	}

	@GetMapping("/buscarporid/{id}")
	public AgenciaDTO buscarAgenciaPorId(@PathVariable(value = "id") Long id) {
		return AgenciaAdapter.agParaDTO(agenciaService.buscarAgPorId(id));
	}

	@GetMapping("/buscarporid/{numero}")
	public AgenciaDTO buscarAgenciaPorNumero(@PathVariable(value = "numero") String numeroAgencia) {
		return AgenciaAdapter.agParaDTO(agenciaService.bucarAgPorNumero(numeroAgencia));
	}

	// APAGAR

	@DeleteMapping("/apagartodas")
	public void apagarTodasAgencias() {
		agenciaService.limparAgs();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarAgenciaPorId(@PathVariable(value = "id") Long id) {
		agenciaService.excluirAgPorId(id);
	}

	// ATUALIZAR

	@PutMapping("/atualizar/{id}")
	public AgenciaDTO atualizar(@PathVariable(value = "id") Long id, @RequestBody AgenciaFormDTO agenciaForm) {
		return AgenciaAdapter.agParaDTO(agenciaService.atualizar(id, agenciaForm));
	}
}
