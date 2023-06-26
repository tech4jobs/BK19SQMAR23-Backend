package br.com.tech4me.tech4doces.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

  List<Produtos> produtos = new ArrayList<>();

  @GetMapping
  public List<Produtos> obterProdutos() {
    return produtos;
  }

  @GetMapping("/{descricao}")
  public Produtos obterProdutoPorNome(@PathVariable String descricao) {
    Produtos produto = produtos.stream()
          .filter(p -> p.getDescricao().equalsIgnoreCase(descricao))
          .findFirst().orElse(null);
    return produto;
  }

  @DeleteMapping("/{descricao}")
  public void removerProduto(@PathVariable String descricao) {
    produtos.removeIf(p -> p.getDescricao().equalsIgnoreCase(descricao));          
  }

  @PostMapping
  public ResponseEntity<String> cadastrarProduto(@RequestBody Produtos produto){
    produtos.add(produto);
    String mensagem = String.format("Categoria: %s - Produto %s cadastrado com sucesso!",
     produto.getTipo(), produto.getDescricao());
    
     return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
  }
  
  
  @PutMapping("/{descricao}")
  public Produtos atualizarProduto(@PathVariable String descricao, 
                                  @RequestBody Produtos produtoNovo) {
    Produtos produto = produtos.stream()
                      .filter(p -> p.getDescricao().equalsIgnoreCase(descricao))
                      .findFirst().orElse(null);

    if (produto != null){
      produto.setTipo(produtoNovo.getTipo());
      produto.setDescricao(produtoNovo.getDescricao());
      produto.setValor(produtoNovo.getValor());
    };

    return produto;
  }
}
