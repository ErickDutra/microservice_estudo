package com.produto.service.produto_microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.service.produto_microservice.dto.ProdutoDto;
import com.produto.service.produto_microservice.integration.ArmazenService;
import com.produto.service.produto_microservice.integration.dto.ArmazenDto;
import com.produto.service.produto_microservice.repository.ProdutoRepository;
import com.produto.service.produto_microservice.tables.Produto;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ArmazenService armazenService;

      

   
    public ProdutoDto saveProduto(ProdutoDto produtoDto) {
    Produto produto = new Produto();
    produto.setArmazen(produtoDto.id_armazen());
    produto.setNome(produtoDto.nome());
    produto.setPrice(produtoDto.price());
    produto.setQuantidade(produtoDto.quantidade());

    Produto produtoDb = produtoRepository.save(produto);

    
    ArmazenDto armazenDto = new ArmazenDto();
    armazenDto.setId(produtoDb.getArmazen());
    armazenDto.setQuantity(produtoDb.getQuantidade());

    try {
        armazenService.postQuantity(armazenDto);
    } catch (Exception e) {
        throw new RuntimeException("Erro ao postar a quantidade para o armazenamento", e);
    }

    return new ProdutoDto(produtoDb.getId(), produtoDb.getArmazen(), produtoDb.getNome(), produtoDb.getQuantidade(), produtoDb.getPrice());
}



}