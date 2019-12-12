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

import com.db1start.cidadesapi.adapter.EstadoAdapter;
import com.db1start.cidadesapi.dto.EstadoDTO;
import com.db1start.cidadesapi.dto.EstadoFormDTO;
import com.db1start.cidadesapi.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	// CRIAR

	@PostMapping("/criar")
	public EstadoDTO criarEstado(@RequestBody EstadoFormDTO estadoForm) {
		return EstadoAdapter.estadoParaDTO(estadoService.criarEstado(estadoForm.getNome()));
	}

	// BUSCAR

	@GetMapping("/buscartodos")
	public List<EstadoDTO> buscarTodosEstados() {
		return EstadoAdapter.listaDeEstadoParaDTO(estadoService.buscarTodos());
	}

	@GetMapping("/buscarporid/{id}")
	public EstadoDTO buscarEstadoPorId(@PathVariable(value = "id") Long id) {
		return EstadoAdapter.estadoParaDTO(estadoService.buscarPorId(id));
	}

	@GetMapping("/buscarpornome/{nome}")
	public EstadoDTO buscarEstadoPorNome(@PathVariable(value = "nome") String nome) {
		return EstadoAdapter.estadoParaDTO(estadoService.buscarPorNome(nome));
	}

	// APAGAR

	@DeleteMapping("/apagartodos")
	public void apagarTodosEstados() {
		estadoService.limparEstados();
	}

	@DeleteMapping("/apagarporid/{id}")
	public void apagarEstadoPorId(@PathVariable(value = "id") Long id) {
		estadoService.excluirEstadoPorId(id);
	}

	// ATUALIZAR

	@PutMapping("/atualizar/{id}")
	public EstadoDTO atualizaEstado(@PathVariable(value = "id") Long id, @RequestBody EstadoFormDTO estadoForm) {
		return EstadoAdapter.estadoParaDTO(estadoService.atualizarEstadoPorId(id, estadoForm));
	}
}
