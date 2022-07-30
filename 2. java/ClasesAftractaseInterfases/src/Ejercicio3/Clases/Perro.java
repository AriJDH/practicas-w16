package Ejercicio3.Clases;

import Ejercicio3.Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonidos() {
        System.out.println("Perro dice Guau!");

    }

    @Override
    public void comerCarne() {
        System.out.println("Perro come carne");
    }
}
