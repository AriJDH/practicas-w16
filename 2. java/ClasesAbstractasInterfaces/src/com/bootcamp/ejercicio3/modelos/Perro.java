package com.bootcamp.ejercicio3.modelos;

import com.bootcamp.ejercicio3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
  @Override
  public void hacerSonido() {
    System.out.println("GUAU");
  }

  @Override
  public void comerCarne() {
    System.out.println("El perro come carne");
  }
}
