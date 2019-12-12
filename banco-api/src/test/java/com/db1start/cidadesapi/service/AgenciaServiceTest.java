package com.db1start.cidadesapi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaServiceTest {

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	private void clean() {
		agenciaService.limparAgs();
		cidadeService.limparCidades();
		estadoService.limparEstados();
	}

	@Test
	public void deveCriarNovaAgencia() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Agencia agencia = agenciaService.criarAg("1", "123", cidade);
		assertNotNull(agencia);
		clean();
	}

	@Test
	public void deveDeletarAgenciaPorId() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Agencia agencia = agenciaService.criarAg("1", "123", cidade);
		Long id = agencia.getId();
		agenciaService.excluirAgPorId(id);
		try {
			agenciaService.buscarAgPorId(id);
		} catch (Exception e) {
			assertEquals("Agencia com id " + id + " nao encontrada no banco de dados.", e.getMessage());
		}
		clean();
	}
}
