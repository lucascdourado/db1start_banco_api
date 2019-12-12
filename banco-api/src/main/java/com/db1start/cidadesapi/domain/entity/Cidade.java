package com.db1start.cidadesapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 60)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "estado_id", referencedColumnName = "id")
	private Estado uf;

	public Cidade() {

	}

	public Cidade(String nome, Estado uf) {
		if (nome == null) {
			throw new RuntimeException("nome nao pode ser nulo");
		}
		if (uf == null) {
			throw new RuntimeException("uf nao pode ser nulo");
		}
		this.nome = nome;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Estado getUf() {
		return uf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}
}
