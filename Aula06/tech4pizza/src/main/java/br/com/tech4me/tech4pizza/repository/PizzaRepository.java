package br.com.tech4me.tech4pizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4pizza.model.Pizza;

public interface PizzaRepository extends MongoRepository<Pizza, String> {
  
}


