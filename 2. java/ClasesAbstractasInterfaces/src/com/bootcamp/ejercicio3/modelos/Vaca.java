package com.bootcamp.ejercicio3.modelos;

import com.bootcamp.ejercicio3.interfaces.Herbivoros;

public class Vaca extends Animal implements Herbivoros {
  @Override
  public void hacerSonido() {
    System.out.println("MUUU");
  }

  @Override
  public void comerHierba() {
    System.out.println("La vaca come hierva");
  }
}
