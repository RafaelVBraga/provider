package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data@Entity
public class Cardapio  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@ManyToMany
	@JoinTable(
	        name = "cardapio_refeicao",
	        joinColumns = @JoinColumn(name = "cardapio_id"),
	        inverseJoinColumns = @JoinColumn(name = "refeicao_id")
	    )
	private List<Refeicao> refeicoes;
	

}
