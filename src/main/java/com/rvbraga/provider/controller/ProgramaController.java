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

import com.rvbraga.provider.model.Programa;
import com.rvbraga.provider.repository.ProgramaRepository;

@RestController
@RequestMapping("/api/programas")
public class ProgramaController {
	@Autowired
    private ProgramaRepository programaRepository;

    @GetMapping
    public ResponseEntity<List<Programa>> listProgramas() {
        List<Programa> programas = programaRepository.findAll();
        return new ResponseEntity<>(programas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programa> getProgramaById(@PathVariable UUID id) {
        Programa programa = programaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid programa Id:" + id));
        return new ResponseEntity<>(programa, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Programa> savePrograma(@RequestBody Programa programa) {
        Programa savedPrograma = programaRepository.save(programa);
        return new ResponseEntity<>(savedPrograma, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programa> updatePrograma(@PathVariable UUID id, @RequestBody Programa programa) {
        programa.setId(id);
        Programa updatedPrograma = programaRepository.save(programa);
        return new ResponseEntity<>(updatedPrograma, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrograma(@PathVariable UUID id) {
        programaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
