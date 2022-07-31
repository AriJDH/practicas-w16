package animales.clases;

import animales.interfaces.Carnivoros;

public class Perro extends Animal implements Carnivoros {

    @Override
    public void emitirSonidos() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne(){
        System.out.println("El perro es un animal carnívoro");
    }

}
