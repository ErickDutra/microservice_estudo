package com.produto.service.produto_microservice.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.integration.armazen.ArmazenProduto;
import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ArmazenService {

    @Autowired
    private final ArmazenProduto armazenProduto;

    public ArmazenDto postQuantity(ArmazenDto armazenDto) {
        try {
            return armazenProduto.postQuantity(armazenDto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao postar quantidade", e);
        }
    }
}
