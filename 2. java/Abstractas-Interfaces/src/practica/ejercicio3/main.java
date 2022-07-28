package practica.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        animales.add(perro);
        animales.add(gato);
        animales.add(vaca);

        animales.forEach(animal -> {animal.emitirSonido();});

       perro.comerCarne();
       vaca.comerHierva();



    }
}
