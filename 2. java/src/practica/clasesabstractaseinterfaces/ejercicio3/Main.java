package practica.clasesabstractaseinterfaces.ejercicio3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        ArrayList<Animal> animales = new ArrayList<>() {
            {
                add(gato);
                add(perro);
                add(vaca);
            }
        };

        for (Animal animal : animales) {
            animal.emitirSonido();

            if (animal instanceof Carnivoro) {
                ((Carnivoro) animal).comerCarne();
            }
            if (animal instanceof Herbivoro) {
                ((Herbivoro) animal).comerHierba();
            }
        }
    }
}
