package Ejercicio3.Clases;

import Ejercicio3.Interfaz.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro() {}

    @Override
    void emitirSonido() {
        System.out.println("El perro hace Guau");
    }


    @Override
    public void comerCarne() {
        System.out.println("El perro come Carne");
    }
}
