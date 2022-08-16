package Ejercicio3.Clases;

import Ejercicio3.Interfaz.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato() {}

    @Override
    void emitirSonido() {
        System.out.println("El gato hace Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come Carne");
    }
}
