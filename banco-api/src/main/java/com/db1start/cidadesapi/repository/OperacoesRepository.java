package com.db1start.cidadesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidadesapi.domain.entity.Operacoes;

public interface OperacoesRepository extends JpaRepository<Operacoes, Long> {

	Operacoes save(String operacao);
}
