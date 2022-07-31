package animales.clases;

import animales.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {


    @Override
    public void emitirSonidos() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba(){
        System.out.println("La vaca es un animal hervíboro");
    }
}
