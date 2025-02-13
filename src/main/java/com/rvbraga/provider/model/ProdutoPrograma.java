package com.rvbraga.provider.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity@Data
public class ProdutoPrograma {

@EmbeddedId
private ProdutoProgramaId produtoProgramaId;

private double percapita;
private int frequencia;

@ManyToOne
@MapsId("produtoId")
@JoinColumn(name = "produto_id")
private Produto produto;

@ManyToOne
@MapsId("programaId")
@JoinColumn(name = "programa_id")
private Programa programa;
}
