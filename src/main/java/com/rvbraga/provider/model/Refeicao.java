package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import lombok.Data;

@Data@Entity
public class Refeicao  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	@ElementCollection
    @CollectionTable(name = "refeicao_produtos", joinColumns = @JoinColumn(name = "refeicao_id"))
    @MapKeyColumn(name = "prod_key")
    @Column(name = "prod_value")
	private HashMap<String,Float> ingredientes;

}
