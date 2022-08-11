package clases_abs_int.animales.models;

import clases_abs_int.animales.interfaces.IComerCarne;

public class Gato extends Animal implements IComerCarne {

    public Gato() {
        super(Tipo.CARNIVORO);
    }

    @Override
    public void emitirSonido() {
        System.out.println("MIAU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo un pollito 🍗.");
    }

    @Override
    public String toString() {
        return "🐈";
    }
}
