package com.db1start.cidadesapi.dto;

public class CidadeDTO {

	private Long id;
	private String nome;
	private EstadoDTO estadoDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoDTO getEstadoDTO() {
		return estadoDTO;
	}

	public void setEstadoDTO(EstadoDTO estadoDTO) {
		this.estadoDTO = estadoDTO;
	}
}
