package com.armazen.armazen_microservice.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "armazen")
public class Armazen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "armazen_id", nullable = false)
    private Long id;

    @Column(name = "armazen_name", nullable = false)
    private String name;

    @Column(name = "armazen_address", nullable = false)
    private String address;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "armazen_status", nullable = false)
    private String status;
    
}
