package com.db1start.cidadesapi.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Agencia agencia;

	@Column
	private Double saldo;

	@OneToOne
	private Cliente cliente;

	@OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Operacoes> historicoDeOperacoes;

	@Column(name = "status")
	StatusConta status;

	public Conta() {

	}

	public Conta(Cliente cliente, Agencia agencia) {
		if (agencia == null) {
			throw new RuntimeException("Agência não pode ser nula");
		}
		if (cliente == null) {
			throw new RuntimeException("Cliente não pode ser nulo");
		}
		this.agencia = agencia;
		this.saldo = 0.0;
		this.cliente = cliente;
		this.historicoDeOperacoes = new ArrayList<>();
		this.status = StatusConta.ATIVA;
	}

	public Long getId() {
		return id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public StatusConta getStatus() {
		return status;
	}

	public List<Operacoes> getHistoricoDeOperacoes() {
		return historicoDeOperacoes;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public void depositar(Double valor) {

		if (valor == null) {
			throw new RuntimeException("Valor nao pode ser nulo.");
		}
		if (valor <= 0) {
			throw new RuntimeException("Valor deve ser maior que zero.");
		}

		Operacoes operacoes = new Operacoes(this, new Date(), TipoOperacao.DEPOSITO, valor);
		this.historicoDeOperacoes.add(operacoes);
		this.saldo += valor;
	}

	public void sacar(Double valor) {

		if (valor == null) {
			throw new RuntimeException("Valor nao pode ser nulo.");
		}
		if (valor <= 0) {
			throw new RuntimeException("Valor deve ser maior que zero.");
		}
		if (valor > this.saldo) {
			throw new RuntimeException("Valor é maior do que o saldo atual.");
		}

		Operacoes operacoes = new Operacoes(this, new Date(), TipoOperacao.SAQUE, valor);
		this.historicoDeOperacoes.add(operacoes);
		this.saldo -= valor;
	}

	public void ativar() {

		if (status == StatusConta.ATIVA) {
			throw new RuntimeException("A conta já está ativa.");
		}

		this.status = StatusConta.ATIVA;
	}

	public void desativar() {

		if (status == StatusConta.INATIVA) {
			throw new RuntimeException("A conta já está inativa.");
		}

		this.status = StatusConta.INATIVA;
	}

}
