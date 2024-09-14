package com.produto.service.produto_microservice.service;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.dto.ProdutoDto;
import com.produto.service.produto_microservice.integration.ArmazenService;
import com.produto.service.produto_microservice.repository.ProdutoRepository;
import com.produto.service.produto_microservice.tables.Produto;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ArmazenService armazenService;

      

    public ProdutoDto saveProduto(ProdutoDto produtoDto){
        Produto produto = new Produto();
        produto.setId(produtoDto.id());
        produto.setId_armazen(produtoDto.id_armazen());
        produto.setNome(produtoDto.nome());
        produto.setPrice(produtoDto.price());
        produto.setQuantidade(produtoDto.quantidade());
        //armazenService.update(produtoDto);
        Produto produtoDb = produtoRepository.save(produto);

        return new ProdutoDto(produtoDb.getId(),produtoDb.getId_armazen() , produtoDb.getNome(),produtoDb.getQuantidade(), produtoDb.getPrice());

    }


}