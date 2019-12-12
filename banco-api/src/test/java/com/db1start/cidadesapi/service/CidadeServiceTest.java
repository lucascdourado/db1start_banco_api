package com.db1start.cidadesapi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.service.CidadeService;
import com.db1start.cidadesapi.service.EstadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CidadeServiceTest {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@After
	public void clean() {
		cidadeService.limparCidades();
		estadoService.limparEstados();
	}

	@Test
	public void deveCriarNovaCidade() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		assertNotNull(cidade);
		estado = estadoService.buscarPorNome("Parana");
		assertEquals(1, estado.getCidades().size());
		System.out.println("Cidade: " + cidade.getNome() + " | Estado: " + cidade.getUf().getNome());
		clean();
	}

	@Test
	public void deveDeletarCidadePorId() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Long id = cidade.getId();
		cidadeService.excluirCidadePorId(id);
		try {
			cidadeService.buscarCidadePorId(id);
		} catch (Exception e) {
			assertEquals("Cidade com id " + id + " nao encontrada no banco de dados.", e.getMessage());
		}
		clean();
	}
}
