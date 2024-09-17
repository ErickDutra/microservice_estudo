package com.produto.service.produto_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produto.service.produto_microservice.tables.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
}
