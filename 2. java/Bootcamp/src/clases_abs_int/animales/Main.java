package clases_abs_int.animales;

import clases_abs_int.animales.models.Animal;
import clases_abs_int.animales.models.Gato;
import clases_abs_int.animales.models.Perro;
import clases_abs_int.animales.models.Vaca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        animales.add(new Perro());
        animales.add(new Gato());
        animales.add(new Vaca());

        Random randomizer = new Random();
        for(Animal animal : animales){
            System.out.printf("Animal: %s - Sonido: ", animal);
            animal.emitirSonido();
            Animal animalParaComer = animales.get(randomizer.nextInt(animales.size()));
            System.out.printf("%s vs %s:\n", animal, animalParaComer);
            animal.comer(animales.get(2));
        }
    }
}
