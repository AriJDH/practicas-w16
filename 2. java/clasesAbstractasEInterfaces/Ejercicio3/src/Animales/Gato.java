package Animales;

import Alimentacion.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }

    @Override
    public void comerAnimal() {
        Carnivoro.comerCarne();
    }

}
