package clases;

import Interfaces.Carnivoros;

public class Gato extends Animal implements Carnivoros {

    public Gato() {
    }

    @Override
    public void comerCarne() {
        System.out.println("El micho come carne");
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Meow");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void sonido() {
        this.emitirSonidos();
    }

}
