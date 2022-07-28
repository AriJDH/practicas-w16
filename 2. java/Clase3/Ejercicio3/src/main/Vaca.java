package main;

import interfaces.ComerHierba;

public class Vaca extends Animal implements ComerHierba {
    @Override
    public void comerHierba() {
        System.out.println("Comiendo Hierbas");
    }

    @Override
    String sonido() {
        return "muuu";
    }
}
