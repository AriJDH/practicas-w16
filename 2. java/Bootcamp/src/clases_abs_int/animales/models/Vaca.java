package clases_abs_int.animales.models;

import clases_abs_int.animales.interfaces.IComerHierva;

public class Vaca extends Animal implements IComerHierva {
    public Vaca() {
        super(Tipo.HERVIBORO);
    }

    @Override
    public void emitirSonido() {
        System.out.println("MUUU");
    }

    @Override
    public void comerHierva() {
        System.out.println("Comiendo pastito 🌿🌿.");
    }
    @Override
    public String toString() {
        return "🐄";
    }
}
