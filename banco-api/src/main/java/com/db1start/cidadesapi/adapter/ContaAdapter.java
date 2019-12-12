package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Conta;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.ContaDTO;
import com.db1start.cidadesapi.dto.OperacoesDTO;

public class ContaAdapter {

	public static ContaDTO contaParaDTO(Conta conta) {
		ContaDTO contaDTO = new ContaDTO();
		contaDTO.setId(conta.getId());
		AgenciaDTO agenciaDTO = AgenciaAdapter.agParaDTO(conta.getAgencia());
		contaDTO.setAgenciaDTO(agenciaDTO);
		contaDTO.setClienteDTO(ClienteAdapter.clienteParaDTO(conta.getCliente()));
		List<OperacoesDTO> historicoDeOperacoesDTO = OperacoesAdapter
				.listaDeOperacoesParaDTO(conta.getHistoricoDeOperacoes());
		contaDTO.setHistoricoDeOperacoesDTO(historicoDeOperacoesDTO);
		contaDTO.setSaldo(conta.getSaldo());
		contaDTO.setStatus(conta.getStatus());
		return contaDTO;
	}

	public static List<ContaDTO> listaDeContasParaDTO(List<Conta> contas) {
		List<ContaDTO> listaDeContasDTO = new ArrayList<>();
		for (Conta conta : contas) {
			listaDeContasDTO.add(contaParaDTO(conta));
		}
		return listaDeContasDTO;
	}
}
