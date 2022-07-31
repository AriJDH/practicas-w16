package com.bootcamp.ejercicio2.interfaces;

public interface Imprimible {
  public static void imprimir(Imprimible documento) {
    documento.imprimir();
  }

  public void imprimir();
}
