package com.rvbraga.provider.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.provider.model.Fornecedor;
import com.rvbraga.provider.repository.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepo;
	
	public List<Fornecedor>findAll(){
		return fornecedorRepo.findAll();
	}
	public Optional<Fornecedor> findById(UUID id) {
		return fornecedorRepo.findById(id);
	}
	public Fornecedor save(Fornecedor fornecedor) {
		return fornecedorRepo.saveAndFlush(fornecedor);
	}
	public void delete(UUID id) {
		fornecedorRepo.deleteById(id);
	}

}
