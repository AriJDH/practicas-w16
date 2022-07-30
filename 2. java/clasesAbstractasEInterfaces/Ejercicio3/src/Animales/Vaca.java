package Animales;

import Alimentacion.Herbivoro;

public class Vaca extends Animal implements Herbivoro {

    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("¡Muuu!");
    }

    @Override
    public void comerAnimal() {
        Herbivoro.comerHierba();
    }

}
