package com.db1start.cidadesapi.dto;

import java.util.Date;

import com.db1start.cidadesapi.domain.entity.TipoOperacao;

public class OperacoesDTO {

	private Date data;
	private TipoOperacao tipo;
	private Double valor;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
