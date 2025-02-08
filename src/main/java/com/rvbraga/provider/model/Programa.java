package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
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
	
	//Esse atributo guardará informação a percapita de todos os produtos
	@ElementCollection
    @CollectionTable(name = "programa_percapita", joinColumns = @JoinColumn(name = "programa_id"))
    @MapKeyColumn(name = "percapita_key")
    @Column(name = "percapita_value")
	private HashMap<String, Float> percapita;
	
	//Esse atributo guardará informação a frequencia de todos os produtos
	@ElementCollection
    @CollectionTable(name = "programa_frequencia", joinColumns = @JoinColumn(name = "programa_id"))
    @MapKeyColumn(name = "frequencia_key")
    @Column(name = "frequencia_value")
	private HashMap<String, Float> frequencia;
	

}
