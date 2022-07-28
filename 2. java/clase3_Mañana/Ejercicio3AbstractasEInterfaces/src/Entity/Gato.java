package Entity;


import Interface.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("miau miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Yo como carne porque soy un gato");
    }
}
