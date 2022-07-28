package ejercicio3.clases;

import ejercicio3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come pasto!");
    }
}
