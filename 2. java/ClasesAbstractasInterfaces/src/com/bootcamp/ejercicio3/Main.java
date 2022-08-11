package com.bootcamp.ejercicio3;

import com.bootcamp.ejercicio3.interfaces.Carnivoro;
import com.bootcamp.ejercicio3.interfaces.Herbivoros;
import com.bootcamp.ejercicio3.modelos.Animal;
import com.bootcamp.ejercicio3.modelos.Gato;
import com.bootcamp.ejercicio3.modelos.Perro;
import com.bootcamp.ejercicio3.modelos.Vaca;

public class Main {
  public static void main(String[] args) {
    Perro perro = new Perro();
    Gato gato = new Gato();
    Vaca vaca = new Vaca();

    perro.hacerSonido();
    gato.hacerSonido();
    vaca.hacerSonido();

    comerAnimal(perro);
    comerAnimal(gato);
    comerAnimal(vaca);
  }

  private static void comerAnimal(Animal animal) {
    if (animal instanceof Carnivoro) ((Carnivoro) animal).comerCarne();
    if (animal instanceof Herbivoros) ((Herbivoros) animal).comerHierba();
  }
}
