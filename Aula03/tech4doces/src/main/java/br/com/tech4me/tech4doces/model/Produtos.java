package br.com.tech4me.tech4doces.model;

public class Produtos {
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
  //#endregion

}
