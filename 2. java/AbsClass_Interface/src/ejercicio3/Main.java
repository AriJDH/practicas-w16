package ejercicio3;

import ejercicio3.Animales.Gato;
import ejercicio3.Animales.Perro;
import ejercicio3.Animales.Vaca;
import ejercicio3.ClaseAbstracta.Animal;

public class Main {
    public static void main(String[] args) {

        Gato gato = new Gato("gato", "carnivoro");
        Perro perro = new Perro("perro", "carnivoro");
        Vaca vaca = new Vaca("vaca", "herbivoro");

        System.out.println("La vaca hace " + vaca.emitirSonido());
        System.out.println("El perro hace " + perro.emitirSonido());
        System.out.println("El gato hace " + gato.emitirSonido());
        System.out.println();
        System.out.println(comerAnimal(vaca));
        System.out.println(comerAnimal(perro));
        System.out.println(comerAnimal(gato));
    }

    private static String comerAnimal(Animal animal){
        return animal.comerAnimal();
    }
}
