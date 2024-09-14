package com.armazen.armazen_microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armazen.armazen_microservice.dto.ArmazenDto;
import com.armazen.armazen_microservice.repository.ArmazenRepository;
import com.armazen.armazen_microservice.table.Armazen;

@Service
public class ArmazenService {

    @Autowired
    private ArmazenRepository armazenRepository;

    public ArmazenDto saveArmazen(ArmazenDto armazenDto) {
        Armazen armazen = new Armazen();
            armazen.setName(armazenDto.name());
            armazen.setAddress(armazenDto.address());
            armazen.setCapacity(armazenDto.capacity());
            armazen.setStatus(armazenDto.status());
        Armazen armazenSalvo = armazenRepository.save(armazen);   
        return new ArmazenDto(armazenSalvo.getName(),armazenSalvo.getAddress(),armazenSalvo.getCapacity(), armazenSalvo.getStatus());
    }

    public ArmazenDto getArmazenById(Long id) {
        Armazen armazen = armazenRepository.findById(id).get();
        return new ArmazenDto(armazen.getName(),armazen.getAddress(),armazen.getCapacity(), armazen.getStatus());
    }

    public List<ArmazenDto> getAllArmazens() {
        return armazenRepository.findAll().stream().map(armazen -> new ArmazenDto(armazen.getName(),armazen.getAddress(),armazen.getCapacity(), armazen.getStatus())).collect(Collectors.toList());
    }

    public ArmazenDto updateArmazen(Long id, ArmazenDto armazenDto) {
        Armazen armazen = armazenRepository.findById(id).get();
            armazen.setName(armazen.getName());
            armazen.setAddress(armazen.getAddress());
            armazen.setCapacity(armazenDto.capacity());
            armazen.setStatus(armazen.getStatus());
        Armazen armazenSalvo = armazenRepository.save(armazen);
        return new ArmazenDto(armazenSalvo.getName(),armazenSalvo.getAddress(),armazenSalvo.getCapacity(), armazenSalvo.getStatus());
    }
}
