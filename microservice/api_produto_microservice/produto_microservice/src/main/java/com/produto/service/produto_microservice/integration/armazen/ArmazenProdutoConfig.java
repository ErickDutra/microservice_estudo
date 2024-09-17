package com.produto.service.produto_microservice.integration.armazen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

@Configuration
public class ArmazenProdutoConfig {
    @Bean
    @Lazy
    public ArmazenProduto armazenProduto(){
        return Feign.builder()
            .decoder(new JacksonDecoder())
            .encoder(new JacksonEncoder())
            .logger(new Slf4jLogger(ArmazenProduto.class))
            .logLevel(feign.Logger.Level.FULL)
            .target(ArmazenProduto.class, "http://localhost:8080/armazen");
    }
    
}