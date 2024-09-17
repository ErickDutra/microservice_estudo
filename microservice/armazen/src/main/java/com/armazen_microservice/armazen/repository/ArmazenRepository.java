package com.armazen_microservice.armazen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.armazen_microservice.armazen.table.Armazen;


public interface ArmazenRepository extends JpaRepository<Armazen, Long> {
    
}
