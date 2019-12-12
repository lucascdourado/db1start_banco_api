package com.db1start.cidadesapi.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operacoes")
public class Operacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn
	private Conta conta;

	@Column(name = "data")
	private Date data;

	@Column(name = "tipo")
	private TipoOperacao tipo;

	@Column(name = "valor")
	private Double valor;

	public Operacoes(Conta conta, Date data, TipoOperacao tipo, Double valor) {

		if (conta == null) {
			throw new RuntimeException("conta nao pode ser nula");
		}
		if (data == null) {
			throw new RuntimeException("data nao pode ser nula");
		}
		if (tipo == null) {
			throw new RuntimeException("tipo nao pode ser nulo");
		}
		if (valor == null) {
			throw new RuntimeException("valor nao pode ser nulo");
		}
		if (valor <= 0) {
			throw new RuntimeException("valor nao pode ser menor que zero");
		}

		this.conta = conta;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Operacoes() {
	}

	public Date getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public Conta getConta() {
		return conta;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public Double getValor() {
		return valor;
	}
}