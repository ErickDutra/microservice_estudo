package com.armazen.armazen_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.armazen.armazen_microservice.table.Armazen;

public interface ArmazenRepository extends JpaRepository<Armazen, Long> {
    
}
