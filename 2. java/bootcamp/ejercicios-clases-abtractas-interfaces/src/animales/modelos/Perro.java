package animales.modelos;

import animales.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void comerCarne() {
        System.out.println("Perro comiendo carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Woof...");
    }

}
