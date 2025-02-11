package com.rvbraga.provider.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable@EqualsAndHashCode
public class ProdutoProgramaId  implements Serializable{
		
	 	private static final long serialVersionUID = 1L;
		private Long produtoId;
	    private Long programaId;

	    
	}

