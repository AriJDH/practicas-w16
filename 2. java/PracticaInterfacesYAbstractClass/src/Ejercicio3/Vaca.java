package Ejercicio3;

public class Vaca extends Animal implements Hervivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba...");
    }
}
