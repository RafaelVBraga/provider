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

import com.rvbraga.provider.model.Refeicao;
import com.rvbraga.provider.repository.RefeicaoRepository;

@RestController
@RequestMapping("/api/refeicoes")
public class RefeicaoController {
	 @Autowired
	    private RefeicaoRepository refeicaoRepository;

	    @GetMapping
	    public ResponseEntity<List<Refeicao>> listRefeicoes() {
	        List<Refeicao> refeicoes = refeicaoRepository.findAll();
	        return new ResponseEntity<>(refeicoes, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Refeicao> getRefeicaoById(@PathVariable UUID id) {
	        Refeicao refeicao = refeicaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid refeicao Id:" + id));
	        return new ResponseEntity<>(refeicao, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Refeicao> saveRefeicao(@RequestBody Refeicao refeicao) {
	        Refeicao savedRefeicao = refeicaoRepository.save(refeicao);
	        return new ResponseEntity<>(savedRefeicao, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Refeicao> updateRefeicao(@PathVariable UUID id, @RequestBody Refeicao refeicao) {
	        refeicao.setId(id);
	        Refeicao updatedRefeicao = refeicaoRepository.save(refeicao);
	        return new ResponseEntity<>(updatedRefeicao, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRefeicao(@PathVariable UUID id) {
	        refeicaoRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
