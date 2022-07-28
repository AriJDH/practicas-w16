package main;

import animales.clases.Animal;
import animales.clases.Gato;
import animales.clases.Perro;
import animales.clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Perro();
        Animal animal2 = new Gato();
        Animal animal3 = new Vaca();

        animal1.emitirSonido();
        animal2.emitirSonido();
        animal3.emitirSonido();

        Animal.comer(animal1);
        Animal.comer(animal2);
        Animal.comer(animal3);
    }
}
