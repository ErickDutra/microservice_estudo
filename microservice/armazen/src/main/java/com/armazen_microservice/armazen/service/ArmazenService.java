package com.armazen_microservice.armazen.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armazen_microservice.armazen.dto.ArmazenCapacityDto;
import com.armazen_microservice.armazen.dto.ArmazenDto;
import com.armazen_microservice.armazen.repository.ArmazenRepository;
import com.armazen_microservice.armazen.table.Armazen;


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
        return new ArmazenDto(armazenSalvo.getId(), armazenSalvo.getName(),armazenSalvo.getAddress(),armazenSalvo.getCapacity(), armazenSalvo.getStatus());
    }

    public ArmazenDto getArmazenById(Long id) {
        Armazen armazen = armazenRepository.findById(id).get();
        return new ArmazenDto(armazen.getId(), armazen.getName(),armazen.getAddress(),armazen.getCapacity(), armazen.getStatus());
    }

    public List<ArmazenDto> getAllArmazens() {
        return armazenRepository.findAll().stream().map(armazen -> new ArmazenDto(armazen.getId(), armazen.getName(),armazen.getAddress(),armazen.getCapacity(), armazen.getStatus())).collect(Collectors.toList());
    }

    public ArmazenDto updateArmazen(Long id, ArmazenDto armazenDto) {
        Armazen armazen = armazenRepository.findById(id).get();
            armazen.setName(armazenDto.name());
            armazen.setAddress(armazenDto.address());
            armazen.setCapacity(armazenDto.capacity());
            armazen.setStatus(armazenDto.status());
        Armazen armazenSalvo = armazenRepository.save(armazen);
        return new ArmazenDto(armazenSalvo.getId(), armazenSalvo.getName(),armazenSalvo.getAddress(),armazenSalvo.getCapacity(), armazenSalvo.getStatus());
    }

    public ArmazenCapacityDto updateEstoque(ArmazenCapacityDto armazenCapacityDto) {
        
        Armazen armazen = armazenRepository.findById(armazenCapacityDto.id()).get();
    
        Integer novaCapacidade = armazen.getCapacity() - armazenCapacityDto.capacity();
        armazen.setCapacity(novaCapacidade); 
    
      
        Armazen armazenSalvo = armazenRepository.save(armazen);
    
        
        return new ArmazenCapacityDto(armazenSalvo.getId(),armazenSalvo.getCapacity()); 
    }
    

}
