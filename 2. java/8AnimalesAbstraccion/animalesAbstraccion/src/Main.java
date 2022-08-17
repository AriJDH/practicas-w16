import interfaces.ComerCarne;
import interfaces.ComerHierba;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();

        Gato gato= new Gato();

        Perro perro = new Perro();

        Vaca vaca = new Vaca();

        animales.add(gato);
        animales.add(perro);
        animales.add(vaca);

        animales.stream()
                .forEach(Animal::emitirSonidos);

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierba();
        System.out.println();

        animales.stream()
                .forEach(Main::comerAnimal);

    }
    public static void comerAnimal(Animal animal){
        if(animal instanceof ComerCarne){
            ((ComerCarne) animal).comerCarne();
        }else{
            ((ComerHierba) animal).comerHierba();
        }
    }
}
