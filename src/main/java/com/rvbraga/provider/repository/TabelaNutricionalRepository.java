package com.rvbraga.provider.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.tabelaNutricional;

@Repository
public interface TabelaNutricionalRepository extends JpaRepository<tabelaNutricional,UUID>{

}
