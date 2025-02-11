package com.rvbraga.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.ProdutoPrograma;
import com.rvbraga.provider.model.ProdutoProgramaId;

@Repository
public interface ProdutoProgramaRepository extends JpaRepository<ProdutoPrograma, ProdutoProgramaId>{

}
