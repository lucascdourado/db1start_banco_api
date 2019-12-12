package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Estado;
import com.db1start.cidadesapi.dto.EstadoDTO;

public class EstadoAdapter {

	public static EstadoDTO estadoParaDTO(Estado estado) {
		EstadoDTO estadoDTO = new EstadoDTO();
		estadoDTO.setId(estado.getId());
		estadoDTO.setNome(estado.getNome());
		return estadoDTO;
	}

	public static List<EstadoDTO> listaDeEstadoParaDTO(List<Estado> estados) {
		List<EstadoDTO> listaDeEstadosDTO = new ArrayList<>();
		for (Estado estado : estados) {
			listaDeEstadosDTO.add(estadoParaDTO(estado));
		}
		return listaDeEstadosDTO;
	}
}
