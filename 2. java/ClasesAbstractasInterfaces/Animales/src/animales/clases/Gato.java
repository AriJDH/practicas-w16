package animales.clases;

import animales.interfaces.Carnivoros;

public class Gato extends Animal implements Carnivoros {


    @Override
    public void emitirSonidos() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne(){
        System.out.println("El gato es un animal carnívoro");
    }
}
