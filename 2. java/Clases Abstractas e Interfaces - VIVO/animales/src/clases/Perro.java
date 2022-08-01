package clases;

import Interfaces.Carnivoros;

public class Perro extends Animal implements Carnivoros {

    public Perro() {
    }

    @Override
    public void comerCarne() {
        System.out.println("El perrito come carne");
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Guau");
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
