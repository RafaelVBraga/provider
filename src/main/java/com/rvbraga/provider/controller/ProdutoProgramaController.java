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

import com.rvbraga.provider.model.Produto;
import com.rvbraga.provider.model.ProdutoPrograma;
import com.rvbraga.provider.model.ProdutoProgramaId;
import com.rvbraga.provider.repository.ProdutoProgramaRepository;

@RestController
@RequestMapping("/api/produtosProgramas")
public class ProdutoProgramaController {
	@Autowired
    private ProdutoProgramaRepository prodProgRepository;
    
    @GetMapping
    public ResponseEntity<List<ProdutoPrograma>> listProdutos() {
        List<ProdutoPrograma> produtosProgramas = prodProgRepository.findAll();
        return new ResponseEntity<>(produtosProgramas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoPrograma> getProdutoById(@PathVariable ProdutoProgramaId id) {
    	ProdutoPrograma produtoPrograma = prodProgRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid produto Id:" + id));
        return new ResponseEntity<>(produtoPrograma, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoPrograma> saveProduto(@RequestBody ProdutoPrograma produtoPrograma) {
    	ProdutoPrograma savedProduto = prodProgRepository.save(produtoPrograma);
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoPrograma> updateProduto(@PathVariable ProdutoProgramaId id, @RequestBody ProdutoPrograma produto) {
        produto.setProdutoProgramaId(id);
        ProdutoPrograma updatedProduto = prodProgRepository.save(produto);
        return new ResponseEntity<>(updatedProduto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable ProdutoProgramaId id) {
        prodProgRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
