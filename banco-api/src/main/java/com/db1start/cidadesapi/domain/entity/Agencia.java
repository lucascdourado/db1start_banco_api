package com.db1start.cidadesapi.domain.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name = "agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_ag")
	private String numeroAg;

	@Column(name = "numero_banco")
	private String numeroBanco;

	@ManyToOne
	@JoinColumn
	private Cidade cidade;

	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conta> conta;

	public Agencia() {

	}

	public Agencia(String numeroAg, String numeroBanco, Cidade cidade) {
		if (numeroAg == null) {
			throw new RuntimeException("Número da agência não pode ser nulo");
		}
		if (numeroBanco == null) {
			throw new RuntimeException("Banco não pode ser nulo");
		}
		if (cidade == null) {
			throw new RuntimeException("Cidade não pode ser nula");
		}
		this.numeroBanco = numeroBanco;
		this.numeroAg = numeroAg;
		this.cidade = cidade;
		this.conta = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNumeroAg() {
		return numeroAg;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setNumeroAg(String numeroAg) {
		this.numeroAg = numeroAg;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public List<Conta> getConta() {
		return conta;
	}
}
