package com.rvbraga.provider.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID>{

	List<Produto> findByFornecedorNome(String nome);

	List<Produto> findByFornecedorCnpj(String cnpj);

	List<Produto> findByNome(String nome);
	
	

}
