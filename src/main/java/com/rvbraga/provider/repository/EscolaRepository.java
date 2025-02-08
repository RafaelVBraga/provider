package com.rvbraga.provider.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, UUID>{

	List<Escola> findByNomeContaining(String nome);

	List<Escola> findByProgramasNome(String programa);
	
	List<Escola> findByRotaNome(String rota);

}
