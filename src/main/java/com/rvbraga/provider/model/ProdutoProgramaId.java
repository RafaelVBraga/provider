package com.rvbraga.provider.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable@EqualsAndHashCode
public class ProdutoProgramaId  implements Serializable{
		
	 	private static final long serialVersionUID = 1L;
		private UUID produtoId;
	    private UUID programaId;

	    
	}

