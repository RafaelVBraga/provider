package com.rvbraga.provider.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.provider.model.Produto;
import com.rvbraga.provider.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepo;
	
	public Produto findById(UUID id) {
		return produtoRepo.findById(id).orElse(null);
	}
	
	public List<Produto> findByFornecedorNome(String nome){
		return produtoRepo.findByFornecedorNome(nome);
	}
	
	public List<Produto> findByFornecedorCnpj(String cnpj){
		return produtoRepo.findByFornecedorCnpj(cnpj);
	}
	
	public List<Produto> findByNome(String nome){
		return produtoRepo.findByNome(nome);
	}
}
