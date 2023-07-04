package br.com.tech4me.tech4doces.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produtos {
  @Id
  private String id;
  private TipoItem tipo;
  private String descricao;
  private double valor;

  //Getters e setters
  //#region
  public TipoItem getTipo() {
    return tipo;
  }
  public void setTipo(TipoItem tipo) {
    this.tipo = tipo;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  //#endregion

}
