package com.db1start.cidadesapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1start.cidadesapi.domain.entity.Cliente;
import com.db1start.cidadesapi.dto.ClienteDTO;

public class ClienteAdapter {

	public static ClienteDTO clienteParaDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		return clienteDTO;
	}

	public static List<ClienteDTO> listaDeClienteParaDTO(List<Cliente> clientes) {
		List<ClienteDTO> listaDeClientesDTO = new ArrayList<>();
		for (Cliente cliente : clientes) {
			listaDeClientesDTO.add(clienteParaDTO(cliente));
		}
		return listaDeClientesDTO;
	}
}
