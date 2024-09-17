package com.produto.service.produto_microservice.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.integration.armazen.ArmazenProduto;
import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ArmazenService {

<<<<<<< HEAD
    @Autowired
    private final ArmazenProduto armazenProduto;

    public ArmazenDto postQuantity(ArmazenDto armazenDto) {
        try {
            return armazenProduto.postQuantity(armazenDto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao postar quantidade", e);
        }
=======
    private ArmazenProduto armazenProduto;

    public void postQuantity(ArmazenDto armazenDto) {
        armazenProduto.postQuantity(armazenDto);
>>>>>>> aa55405700ac5828f009268a96285235397d99af
    }
}
