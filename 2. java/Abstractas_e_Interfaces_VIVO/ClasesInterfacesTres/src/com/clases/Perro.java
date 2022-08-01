package com.clases;

import com.interfaces.Carnivoros;

public class Perro extends Animal implements Carnivoros {




    @Override
    public void emitirSonido() {
        System.out.println("Guuua");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
