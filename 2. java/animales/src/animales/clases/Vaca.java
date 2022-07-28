package animales.clases;

import animales.interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }
}
