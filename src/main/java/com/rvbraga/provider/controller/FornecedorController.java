package com.rvbraga.provider.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbraga.provider.model.Fornecedor;
import com.rvbraga.provider.repository.FornecedorRepository;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
	@Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable UUID id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id do fornecedor inválido:" + id));
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @PostMapping 
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody Fornecedor fornecedor) {
    
    	Fornecedor savedFornecedor = fornecedorRepository.save(fornecedor);
        return new ResponseEntity<>(savedFornecedor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable UUID id, @RequestBody Fornecedor fornecedor) {
        fornecedor.setId(id);
        Fornecedor updatedFornecedor = fornecedorRepository.save(fornecedor);
        return new ResponseEntity<>(updatedFornecedor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable UUID id) {
        fornecedorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
