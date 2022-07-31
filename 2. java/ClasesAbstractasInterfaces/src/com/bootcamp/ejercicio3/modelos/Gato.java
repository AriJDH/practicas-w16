package com.bootcamp.ejercicio3.modelos;

import com.bootcamp.ejercicio3.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
  @Override
  public void hacerSonido() {
    System.out.println("MIAU");
  }

  @Override
  public void comerCarne() {
    System.out.println("El gato come carne");
  }
}
