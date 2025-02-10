package com.rvbraga.provider.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, UUID>{

}
