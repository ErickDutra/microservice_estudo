package com.armazen_microservice.armazen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armazen_microservice.armazen.dto.ArmazenCapacityDto;
import com.armazen_microservice.armazen.dto.ArmazenDto;
import com.armazen_microservice.armazen.service.ArmazenService;


@RestController
@CrossOrigin("*")
@RequestMapping("/armazen")
public class ArmazenController {

    @Autowired
    private ArmazenService armazenService;

    @PostMapping("/salvar")
    public ResponseEntity<ArmazenDto> saveArmazen(@RequestBody ArmazenDto armazenDto) {
        return ResponseEntity.ok(armazenService.saveArmazen(armazenDto));
    }

    @GetMapping("/buscar")
    public ResponseEntity<ArmazenDto> getArmazenById(@RequestBody Long id) {
        return ResponseEntity.ok(armazenService.getArmazenById(id));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<ArmazenDto>> getAllArmazens() {
        return ResponseEntity.ok(armazenService.getAllArmazens());
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ArmazenDto> updateArmazen(@RequestBody Long id, @RequestBody ArmazenDto armazenDto) {
        return ResponseEntity.ok(armazenService.updateArmazen(id, armazenDto));
    }

    @PostMapping("/atualizar-estoque")
    public ResponseEntity<ArmazenCapacityDto> updateEstoque(@RequestBody Long idArmazen, @RequestBody int quantidade) {
        return ResponseEntity.ok(armazenService.updateEstoque(idArmazen, quantidade));
    }
    
    
}
