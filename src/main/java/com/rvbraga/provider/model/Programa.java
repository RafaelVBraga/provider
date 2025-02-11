package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Programa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	@ManyToMany(mappedBy = "programas")
    private Set<Escola> escolas;
	
	@OneToMany(mappedBy = "produtoProgramaId.programa", cascade = CascadeType.ALL)
    private List<ProdutoPrograma> produtos = new ArrayList<>();
	

}
