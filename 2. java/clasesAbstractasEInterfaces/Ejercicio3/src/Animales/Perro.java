package Animales;

import Alimentacion.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }

    @Override
    public void comerAnimal() {
        Carnivoro.comerCarne();
    }

}
