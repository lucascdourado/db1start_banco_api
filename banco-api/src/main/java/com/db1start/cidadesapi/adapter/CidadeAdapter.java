package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Cidade;
import com.db1start.cidadesapi.dto.CidadeDTO;
import com.db1start.cidadesapi.dto.EstadoDTO;

public class CidadeAdapter {

	public static CidadeDTO cidadeParaDTO(Cidade cidade) {
		CidadeDTO cidadeDTO = new CidadeDTO();
		cidadeDTO.setId(cidade.getId());
		cidadeDTO.setNome(cidade.getNome());
		EstadoDTO estadoDTO = EstadoAdapter.estadoParaDTO(cidade.getUf());
		cidadeDTO.setEstadoDTO(estadoDTO);
		return cidadeDTO;
	}

	public static List<CidadeDTO> listaDeCidadeParaDTO(List<Cidade> cidades) {
		List<CidadeDTO> listaDeCidadesDTO = new ArrayList<>();
		for (Cidade cidade : cidades) {
			listaDeCidadesDTO.add(cidadeParaDTO(cidade));
		}
		return listaDeCidadesDTO;
	}
}
