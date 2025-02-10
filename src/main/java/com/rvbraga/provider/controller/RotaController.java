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

import com.rvbraga.provider.model.Rota;
import com.rvbraga.provider.repository.RotaRepository;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {
	 @Autowired
	    private RotaRepository rotaRepository;

	    @GetMapping
	    public ResponseEntity<List<Rota>> listRotas() {
	        List<Rota> rotas = rotaRepository.findAll();
	        return new ResponseEntity<>(rotas, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Rota> getRotaById(@PathVariable UUID id) {
	        Rota rota = rotaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rota Id:" + id));
	        return new ResponseEntity<>(rota, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Rota> saveRota(@RequestBody Rota rota) {
	        Rota savedRota = rotaRepository.save(rota);
	        return new ResponseEntity<>(savedRota, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Rota> updateRota(@PathVariable UUID id, @RequestBody Rota rota) {
	        rota.setId(id);
	        Rota updatedRota = rotaRepository.save(rota);
	        return new ResponseEntity<>(updatedRota, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRota(@PathVariable UUID id) {
	    	System.out.println("Deletando");
	        rotaRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
