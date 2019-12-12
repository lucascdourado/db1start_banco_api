package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Operacoes;
import com.db1start.cidadesapi.dto.OperacoesDTO;

public class OperacoesAdapter {

	public static OperacoesDTO operacaoParaDTO(Operacoes operacao) {
		OperacoesDTO operacaoDTO = new OperacoesDTO();
		operacaoDTO.setData(operacao.getData());
		operacaoDTO.setTipo(operacao.getTipo());
		operacaoDTO.setValor(operacao.getValor());
		return operacaoDTO;
	}

	public static List<OperacoesDTO> listaDeOperacoesParaDTO(List<Operacoes> operacoes) {
		List<OperacoesDTO> listaDeOperacoesDTO = new ArrayList<>();
		for (Operacoes operacao : operacoes) {
			listaDeOperacoesDTO.add(operacaoParaDTO(operacao));
		}
		return listaDeOperacoesDTO;
	}

}
