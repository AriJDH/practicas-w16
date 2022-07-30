package Ejercicio3.Clases;

import Ejercicio3.Clases.Animal;
import Ejercicio3.Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonidos() {
        System.out.println("Gato dice Miau!");

    }

    @Override
    public void comerCarne() {
        System.out.println("Gato come carne");
    }
}
