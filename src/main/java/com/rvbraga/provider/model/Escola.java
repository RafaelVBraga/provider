package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Escola  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private Integer qntAlunos;
	@OneToOne
	private Endereco endereco;
	@ManyToMany
    @JoinTable(
        name = "escola_programa",
        joinColumns = @JoinColumn(name = "escola_id"),
        inverseJoinColumns = @JoinColumn(name = "programa_id")
    )
	private Set<Programa> programas;
	@ManyToOne
    @JoinColumn(name = "rota_id", nullable = false)
	private Rota rota;

}
