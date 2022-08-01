package poo.ejercicioAnimal;

public class Gato extends Animal implements Carnivoro {

    @Override
    void emitirSonido() {
        System.out.println("Miau miau");
    }

    @Override
    void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato comiendo carne");
    }
}
