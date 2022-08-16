package Ejercicio3.Clases;

import Ejercicio3.Interfaz.Carnivoro;
import Ejercicio3.Interfaz.Hervíboro;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        System.out.println("Perro");
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        System.out.println("Gato");
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        System.out.println("Vaca");
        vaca.emitirSonido();
        vaca.comerHierba();

        System.out.println("Método comer animal");
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);

    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        } else {
            ((Hervíboro) animal).comerHierba();
        }

    }
}
