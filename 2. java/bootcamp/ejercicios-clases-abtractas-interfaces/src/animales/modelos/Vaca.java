package animales.modelos;

import animales.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba...");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu...");
    }
}
