package main;

import interfaces.ComerCarne;

public class Perro extends Animal implements ComerCarne {
    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }

    @Override
    String sonido() {
        return "guau";
    }
}
