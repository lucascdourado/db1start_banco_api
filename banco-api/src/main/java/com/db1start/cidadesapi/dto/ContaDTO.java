package com.db1start.cidadesapi.dto;

import java.util.List;

import com.db1start.cidadesapi.domain.entity.StatusConta;

public class ContaDTO {

	private Long id;
	private Double saldo;
	private ClienteDTO clienteDTO;
	private AgenciaDTO agenciaDTO;
	private List<OperacoesDTO> historicoDeOperacoesDTO;
	private StatusConta status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public AgenciaDTO getAgenciaDTO() {
		return agenciaDTO;
	}

	public void setAgenciaDTO(AgenciaDTO agenciaDTO) {
		this.agenciaDTO = agenciaDTO;
	}

	public List<OperacoesDTO> getHistoricoDeOperacoesDTO() {
		return historicoDeOperacoesDTO;
	}

	public void setHistoricoDeOperacoesDTO(List<OperacoesDTO> historicoDeOperacoesDTO) {
		this.historicoDeOperacoesDTO = historicoDeOperacoesDTO;
	}

	public StatusConta getStatus() {
		return status;
	}

	public void setStatus(StatusConta status) {
		this.status = status;
	}
}
