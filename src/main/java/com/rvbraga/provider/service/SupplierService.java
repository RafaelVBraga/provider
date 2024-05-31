package com.rvbraga.provider.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.provider.model.Supplier;
import com.rvbraga.provider.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supRepo;
	
	public List<Supplier>findAll(){
		return supRepo.findAll();
	}
	public Optional<Supplier> findById(UUID id) {
		return supRepo.findById(id);
	}
	public Supplier save(Supplier supplier) {
		return supRepo.saveAndFlush(supplier);
	}
	public void delete(UUID id) {
		supRepo.deleteById(id);
	}

}
