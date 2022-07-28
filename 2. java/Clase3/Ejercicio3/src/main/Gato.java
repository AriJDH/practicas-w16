package main;

import interfaces.ComerCarne;
import interfaces.ComerHierba;

public class Gato extends Animal implements ComerCarne {
    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }

    @Override
    String sonido() {
        return "miau";
    }
}
