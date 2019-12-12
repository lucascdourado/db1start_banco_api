package com.db1start.cidadesapi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.service.EstadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {

	@Autowired
	private EstadoService estadoService;

	private void clean() {
		estadoService.limparEstados();
	}

	@Test
	public void deveCriarNovoEstado() {
		Estado estado = estadoService.criarEstado("Parana");
		assertNotNull(estado);
		System.out.println("ID do Estado: " + estado.getId());
		clean();
	}

	@Test
	public void deveBuscarEstadoPorNome() {
		estadoService.criarEstado("Parana");
		Estado estado = estadoService.buscarPorNome("Parana");
		System.out.println("Nome do estado: " + estado.getNome());
		assertNotNull(estado);
		clean();
	}

	@Test
	public void deveLancarExcessaoDeEstadoNaoExiste() {
		try {
			estadoService.buscarPorNome("Acre");
		} catch (Exception e) {
			assertEquals("Estado com nome Acre nao encontrado no banco de dados.", e.getMessage());
		}
	}

	@Test
	public void deveDeletarContaPorId() {
		Estado estado = estadoService.criarEstado("Parana");
		Long id = estado.getId();
		estadoService.excluirEstadoPorId(id);
		try {
			estadoService.buscarPorId(id);
		} catch (Exception e) {
			assertEquals("Estado com id " + id + " nao encontrado no banco de dados.", e.getMessage());
		}
		clean();
	}
}
