package clases_abs_int.animales.models;

import clases_abs_int.animales.interfaces.IComerCarne;

public class Perro extends Animal implements IComerCarne {

    public Perro() {
        super(Tipo.CARNIVORO);
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne 🥩.");
    }

    @Override
    public String toString() {
        return "🐕";
    }

    @Override
    public void emitirSonido() {
        System.out.println("GUAU");
    }
}
