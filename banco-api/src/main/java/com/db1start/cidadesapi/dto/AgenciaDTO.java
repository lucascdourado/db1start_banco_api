package com.db1start.cidadesapi.dto;

public class AgenciaDTO {

	private Long id;
	private String numeroAgencia;
	private CidadeDTO cidadeDTO;
	private String numeroBanco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroAg() {
		return numeroAgencia;
	}

	public void setNumeroAg(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public CidadeDTO getCidadeDTO() {
		return cidadeDTO;
	}

	public void setCidadeDTO(CidadeDTO cidadeDTO) {
		this.cidadeDTO = cidadeDTO;
	}

	public String getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(String numeroBanco) {
		this.numeroBanco = numeroBanco;
	}
}
