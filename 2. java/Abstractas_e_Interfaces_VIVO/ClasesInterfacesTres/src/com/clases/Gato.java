package com.clases;

import com.interfaces.Carnivoros;

public class Gato extends Animal implements Carnivoros {



    @Override
    public void emitirSonido() {
        System.out.println("Miiiiaau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
