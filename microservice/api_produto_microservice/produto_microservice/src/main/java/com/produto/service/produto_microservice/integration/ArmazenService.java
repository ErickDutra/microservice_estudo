package com.produto.service.produto_microservice.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.integration.armazen.ArmazenProduto;
import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ArmazenService {
    private ArmazenProduto armazenProduto;

    public ArmazenDto postQuantity(ArmazenDto armazenDto) {
        try {
            ResponseEntity<ArmazenDto> response = armazenProduto.postQuantity(armazenDto);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new RuntimeException("Erro na resposta da API: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao postar quantidade", e);
        }
    }
}
