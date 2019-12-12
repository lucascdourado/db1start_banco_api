package com.db1start.cidadesapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1start.cidadesapi.domain.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Optional<Conta> findById(Long id);
}
