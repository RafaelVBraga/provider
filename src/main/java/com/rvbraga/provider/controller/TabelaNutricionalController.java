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

import com.rvbraga.provider.model.TabelaNutricional;
import com.rvbraga.provider.repository.TabelaNutricionalRepository;

@RestController
@RequestMapping("/api/tabelanutricional")
public class TabelaNutricionalController {
	@Autowired
    private TabelaNutricionalRepository tabelaNutricionalRepository;

    @GetMapping
    public ResponseEntity<List<TabelaNutricional>> listTabelaNutricional() {
        List<TabelaNutricional> tabelaNutricionalList = tabelaNutricionalRepository.findAll();
        return new ResponseEntity<>(tabelaNutricionalList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TabelaNutricional> getTabelaNutricionalById(@PathVariable UUID id) {
        TabelaNutricional tabelaNutricional = tabelaNutricionalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid TabelaNutricional Id:" + id));
        return new ResponseEntity<>(tabelaNutricional, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TabelaNutricional> saveTabelaNutricional(@RequestBody TabelaNutricional tabelaNutricional) {
        TabelaNutricional savedTabelaNutricional = tabelaNutricionalRepository.save(tabelaNutricional);
        return new ResponseEntity<>(savedTabelaNutricional, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TabelaNutricional> updateTabelaNutricional(@PathVariable UUID id, @RequestBody TabelaNutricional tabelaNutricional) {
        tabelaNutricional.setId(id);
        TabelaNutricional updatedTabelaNutricional = tabelaNutricionalRepository.save(tabelaNutricional);
        return new ResponseEntity<>(updatedTabelaNutricional, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTabelaNutricional(@PathVariable UUID id) {
        tabelaNutricionalRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
