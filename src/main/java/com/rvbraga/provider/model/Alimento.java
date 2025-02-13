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

@Entity@Data
public class Alimento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String descricao;
	private Float energiaKcal;
	private Float energiaKJ;
	@ManyToMany()
	 @JoinTable(
		        name = "alimento_composicao",
		        joinColumns = @JoinColumn(name = "alimento_id"),
		        inverseJoinColumns = @JoinColumn(name = "composicao_id")
		    )
	List<Composicao> composicoes;

}
