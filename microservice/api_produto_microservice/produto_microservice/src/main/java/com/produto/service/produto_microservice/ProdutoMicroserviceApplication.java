package com.produto.service.produto_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProdutoMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoMicroserviceApplication.class, args);
	}

}
