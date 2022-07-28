package Veterinaria;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
