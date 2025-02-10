package com.rvbraga.provider.service;

import java.time.LocalDate;
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
	public Fornecedor findById(UUID id) {
		return fornecedorRepo.findById(id).orElse(null);
	}
	public Fornecedor save(Fornecedor fornecedor) {
		fornecedor.setDataRegistro(LocalDate.now());
		return fornecedorRepo.saveAndFlush(fornecedor);
	}
	public void delete(UUID id) {
		fornecedorRepo.deleteById(id);
	}

}
