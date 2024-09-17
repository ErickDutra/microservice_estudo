package com.produto.service.produto_microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.service.produto_microservice.dto.ProdutoDto;
import com.produto.service.produto_microservice.service.ProdutoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/salvar")
    public ProdutoDto saveProduto(@RequestBody ProdutoDto produtoDto) {
        return produtoService.saveProduto(produtoDto);
    }

}
