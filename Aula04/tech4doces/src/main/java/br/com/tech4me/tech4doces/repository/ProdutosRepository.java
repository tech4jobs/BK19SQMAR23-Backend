package br.com.tech4me.tech4doces.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4doces.model.Produtos;

public interface ProdutosRepository extends MongoRepository<Produtos, String> {
  
}



