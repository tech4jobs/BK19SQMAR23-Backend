package br.com.tech4me.tech4pizza.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.tech4pizza.shared.PizzaCompletoDto;
import br.com.tech4me.tech4pizza.shared.PizzaDto;

public interface PizzaService {
  List<PizzaDto> obterTodas();
  Optional<PizzaCompletoDto> obterPorId(String id);
  PizzaCompletoDto cadastrar(PizzaCompletoDto dto);
  Optional<PizzaCompletoDto> atualizarPorId(String id, PizzaCompletoDto dto);
  void excluirPorId(String id); 
}

