package Ejercicio3.Clases;

import Ejercicio3.Interfaz.Hervíboro;

public class Vaca extends Animal implements Hervíboro {
    public Vaca() {}

    @Override
    void emitirSonido() {
        System.out.println("La vaca hace muuu");
    }


    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
