package com.produto.service.produto_microservice.integration;

import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.integration.armazen.ArmazenProduto;
import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ArmazenService {

    private final ArmazenProduto armazenProduto;

    public void postQuantity(ArmazenDto armazenDto) {
        armazenProduto.postQuantity(armazenDto);
    }
}
