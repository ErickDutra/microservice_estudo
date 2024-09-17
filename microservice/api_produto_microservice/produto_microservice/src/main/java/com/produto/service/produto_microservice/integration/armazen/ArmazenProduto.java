package com.produto.service.produto_microservice.integration.armazen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.produto.service.produto_microservice.integration.dto.ArmazenDto;

import feign.RequestLine;


@FeignClient(name = "armazen-produto", url = "http://localhost:8080/armazen")
public interface ArmazenProduto {

    //@PostMapping("/atualizar-estoque")
    @RequestLine("POST /atualizar-estoque")
    ResponseEntity<ArmazenDto> postQuantity(@RequestBody ArmazenDto armazenDto);
}