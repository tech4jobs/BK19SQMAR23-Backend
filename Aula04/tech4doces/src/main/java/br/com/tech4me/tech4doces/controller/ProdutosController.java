package br.com.tech4me.tech4doces.controller;

import java.util.List;

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

import br.com.tech4me.tech4doces.model.Produtos;
import br.com.tech4me.tech4doces.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
  @Autowired
  private ProdutosRepository repositorio;

  @GetMapping
  public List<Produtos> obterProdutos() {
    return repositorio.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produtos> obterProdutoPorNome(@PathVariable String id) {
    Produtos produto = repositorio.findById(id).orElse(null);
    
    if (produto != null) {
      return new ResponseEntity<>(produto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removerProduto(@PathVariable String id) {
    repositorio.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);         
  }

  @PostMapping
  public ResponseEntity<Produtos> cadastrarProduto(@RequestBody Produtos produto){
    repositorio.save(produto);
    
    return new ResponseEntity<>(produto, HttpStatus.CREATED);
  }
  
  
  @PutMapping("/{id}")
  public ResponseEntity<Produtos> atualizarProduto(@PathVariable String id, 
                                  @RequestBody Produtos produtoNovo) {
    Produtos produto = repositorio.findById(id).orElse(null);

    if (produto != null){
      produto.setTipo(produtoNovo.getTipo());
      produto.setDescricao(produtoNovo.getDescricao());
      produto.setValor(produtoNovo.getValor());
      return new ResponseEntity<>(produto, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }
  }
}
