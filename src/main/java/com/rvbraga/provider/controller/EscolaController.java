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

import com.rvbraga.provider.model.Escola;
import com.rvbraga.provider.repository.EscolaRepository;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {
	 @Autowired
	    private EscolaRepository escolaRepository;

	    @GetMapping
	    public ResponseEntity<List<Escola>> listEscolas() {
	        List<Escola> escolas = escolaRepository.findAll();
	        return new ResponseEntity<>(escolas, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Escola> getEscolaById(@PathVariable UUID id) {
	        Escola escola = escolaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid escola Id:" + id));
	        return new ResponseEntity<>(escola, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Escola> saveEscola(@RequestBody Escola escola) {
	        Escola savedEscola = escolaRepository.save(escola);
	        return new ResponseEntity<>(savedEscola, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Escola> updateEscola(@PathVariable UUID id, @RequestBody Escola escola) {
	        escola.setId(id);
	        Escola updatedEscola = escolaRepository.save(escola);
	        return new ResponseEntity<>(updatedEscola, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEscola(@PathVariable UUID id) {
	        escolaRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
