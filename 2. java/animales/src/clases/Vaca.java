package clases;

import Interfaces.Hervivoros;

public class Vaca extends Animal implements Hervivoros {

    public Vaca() {
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come gramilla");
    }

    @Override
    public void emitirSonidos() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }

    @Override
    public void sonido() {
        this.emitirSonidos();
    }
}
