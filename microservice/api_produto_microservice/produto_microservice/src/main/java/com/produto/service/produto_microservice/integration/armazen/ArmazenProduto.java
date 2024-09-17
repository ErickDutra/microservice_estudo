package com.produto.service.produto_microservice.integration.armazen;
import org.springframework.cloud.openfeign.FeignClient;

import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import feign.Headers;
import feign.RequestLine;


@FeignClient(name = "armazen-produto", url = "http://localhost:8080/armazen")
public interface ArmazenProduto {

    @RequestLine("POST /atualizar-estoque")
    @Headers("Content-Type: application/json")
    ArmazenDto postQuantity(ArmazenDto armazenDto);
}