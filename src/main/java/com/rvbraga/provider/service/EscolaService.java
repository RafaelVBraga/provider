package com.rvbraga.provider.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.provider.model.Escola;
import com.rvbraga.provider.repository.EscolaRepository;

@Service
public class EscolaService {
	@Autowired
	private EscolaRepository escolaRepo;
	
	public Escola findById(UUID id) {
		return escolaRepo.findById(id).orElse(null);
	}
	
	public List<Escola> findbyNome(String nome){
		return escolaRepo.findByNomeContaining(nome);
	}
	public List<Escola> findByPrograma(String programa){
		return escolaRepo.findByProgramasNome(programa);
	}
	
	public List<Escola> findByRota(String rota){
		return escolaRepo.findByRotaNome(rota);
	}	
}
