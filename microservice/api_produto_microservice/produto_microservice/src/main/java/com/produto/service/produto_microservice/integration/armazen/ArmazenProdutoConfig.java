package com.produto.service.produto_microservice.integration.armazen;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

@Component
public class ArmazenProdutoConfig {
    @Bean
    public ArmazenProduto armazenProduto(){
        return Feign.builder()
            .decoder(new JacksonDecoder())
            .encoder(new JacksonEncoder())
            .logger(new Slf4jLogger(ArmazenProduto.class))
            .logLevel(feign.Logger.Level.FULL)
            .target(ArmazenProduto.class, "http://localhost:8080");
    }
    
}