package com.db1start.cidadesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidadesapi.domain.entity.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

	Optional<Agencia> findByNumeroAg(String numeroAg);

	Optional<Agencia> findById(Long id);
}
