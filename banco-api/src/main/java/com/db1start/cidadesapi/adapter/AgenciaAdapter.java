package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Agencia;
import com.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1start.cidadesapi.dto.CidadeDTO;

public class AgenciaAdapter {

	public static AgenciaDTO agParaDTO(Agencia agencia) {
		AgenciaDTO agenciaDTO = new AgenciaDTO();
		agenciaDTO.setId(agencia.getId());
		CidadeDTO cidadeDTO = CidadeAdapter.cidadeParaDTO(agencia.getCidade());
		agenciaDTO.setCidadeDTO(cidadeDTO);
		agenciaDTO.setNumeroAg(agencia.getNumeroAg());
		agenciaDTO.setNumeroBanco(agencia.getNumeroBanco());
		return agenciaDTO;
	}

	public static List<AgenciaDTO> listaDeAgenciasParaDTO(List<Agencia> agencias) {
		List<AgenciaDTO> listaDeAgenciasDTO = new ArrayList<>();
		for (Agencia agencia : agencias) {
			listaDeAgenciasDTO.add(agParaDTO(agencia));
		}
		return listaDeAgenciasDTO;
	}
}
