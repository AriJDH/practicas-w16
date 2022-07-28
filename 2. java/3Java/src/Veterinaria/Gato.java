package Veterinaria;

public class Gato extends Animal implements ICarnivoro {

    @Override
    public void hacerSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
