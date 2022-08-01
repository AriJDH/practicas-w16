package com.clases;

import com.interfaces.Herviboros;

public class Vaca extends Animal implements Herviboros {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba");
    }


}
