package com.rvbraga.provider.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvbraga.provider.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, UUID>{

}
