package com.db1start.cidadesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidadesapi.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	Optional<Cidade> findByNome(String nome);

	Optional<Cidade> findById(Long id);
}
