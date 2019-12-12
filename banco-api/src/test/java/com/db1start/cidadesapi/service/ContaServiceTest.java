package com.db1start.cidadesapi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaServiceTest {

	@Autowired
	private ContaService contaService;

	@Autowired
	private AgenciaService agenciaService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private ClienteService clienteService;

	@After
	public void clean() {
		contaService.limparContas();
		agenciaService.limparAgs();
		cidadeService.limparCidades();
		estadoService.limparEstados();
		clienteService.limparClientes();
	}

	private Conta criaContaParaTeste() {
		Estado estado = estadoService.criarEstado("Parana");
		Cidade cidade = cidadeService.criarCidade("Maringa", estado);
		Agencia agencia = agenciaService.criarAg("123", "123", cidade);
		Cliente cliente = clienteService.criarCliente("Lucas", "123");
		return contaService.criarConta(cliente, agencia);
	}

	@Test
	public void deveCriarNovaConta() {

		Conta conta = criaContaParaTeste();

		assertNotNull(conta);
		clean();
	}

	@Test
	public void deveDeletarContaPorId() {
		Conta conta = criaContaParaTeste();
		Long id = conta.getId();
		contaService.excluirContaPorId(id);
		try {
			contaService.buscarContaPorId(id);
		} catch (Exception e) {
			assertEquals("Conta com id " + id + " nao encontrada no banco de dados.", e.getMessage());
		}
		clean();
	}

	@Test
	public void deveDepositar() {

		Conta conta = criaContaParaTeste();
		Long id = conta.getId();
		Double valor = 99.5;
		conta = contaService.depositar(id, valor);
		assertEquals(valor, conta.getSaldo());
		assertEquals(1, conta.getHistoricoDeOperacoes().size());
		clean();
	}

	@Test
	public void deveSacar() {

		Conta conta = criaContaParaTeste();
		Long id = conta.getId();
		Double saldoInicial = 100.0;
		conta = contaService.depositar(id, saldoInicial);

		Double valorSacado = 30.0;
		conta = contaService.sacar(id, valorSacado);

		Double saldoFinal = saldoInicial - valorSacado;
		assertEquals(saldoFinal, conta.getSaldo());
		assertEquals(2, conta.getHistoricoDeOperacoes().size());
		clean();
	}

}
