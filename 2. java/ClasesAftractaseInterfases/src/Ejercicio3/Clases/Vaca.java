package Ejercicio3.Clases;

import Ejercicio3.Interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void emitirSonidos() {
        System.out.println("Vaca dice Muu!");

    }

    @Override
    public void comerhierva() {
        System.out.println("Vaca come hierva");
    }
}
