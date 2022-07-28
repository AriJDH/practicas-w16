package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();

        animales.add(new Gato());
        animales.add(new Vaca());
        animales.add(new Perro());

        for (Animal a: animales) {
            a.emitirSonido();
            comerAnimal(a);
        }
    }

    public static void comerAnimal(Animal a){
         a.comer();
    }
}
