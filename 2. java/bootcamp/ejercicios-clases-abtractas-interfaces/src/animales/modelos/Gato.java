package animales.modelos;

import animales.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void comerCarne() {
        System.out.println("Gato comiendo carne...");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miaww...");
    }
}
