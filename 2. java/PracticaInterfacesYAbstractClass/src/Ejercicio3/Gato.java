package Ejercicio3;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Miau!");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }
}
