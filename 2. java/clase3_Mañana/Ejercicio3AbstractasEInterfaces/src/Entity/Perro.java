package Entity;

import Interface.Carnivoro;

public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("guau guau guau");
    }


    @Override
    public void comerCarne() {
        System.out.println("yo como carne porque soy un perro");
    }
}
