package br.com.tech4me.tech4pizza.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.tech4pizza.service.PizzaService;
import br.com.tech4me.tech4pizza.shared.PizzaCompletoDto;
import br.com.tech4me.tech4pizza.shared.PizzaDto;

@RestController
@RequestMapping("pizzas")
public class PizzaController {
  @Autowired
  private PizzaService servico;

  @GetMapping
  public ResponseEntity<List<PizzaDto>> obterPizzas() {
    return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PizzaCompletoDto> obterPizzaPorId(@PathVariable String id) {
    Optional<PizzaCompletoDto> pizza = servico.obterPorId(id);

    if (pizza.isPresent()) {
      return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<PizzaCompletoDto> cadastrarPizza(@RequestBody PizzaCompletoDto pizza) {
    return new ResponseEntity<>(servico.cadastrar(pizza), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirPizzaPorId(@PathVariable String id) {
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PizzaCompletoDto> atualizarPizza(@PathVariable String id, @RequestBody PizzaCompletoDto pizza) {
    Optional<PizzaCompletoDto> pizzaAtualizada = servico.atualizarPorId(id, pizza);

    if (pizzaAtualizada.isPresent()) {
      return new ResponseEntity<>(pizzaAtualizada.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


}



