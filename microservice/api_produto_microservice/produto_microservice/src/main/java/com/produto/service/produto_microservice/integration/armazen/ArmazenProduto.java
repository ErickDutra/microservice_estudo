package com.produto.service.produto_microservice.integration.armazen;

import org.springframework.cloud.openfeign.FeignClient;

import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import feign.RequestLine;

@FeignClient(name = "armazen-service", url = "http://localhost:8081")
public interface ArmazenProduto {
    @RequestLine("PUT /armazen/atualizar")
    void update(ArmazenDto armazenDto);
}
