package ejercicioTres;

import ejercicioTres.animales.Gato;
import ejercicioTres.animales.Perro;
import ejercicioTres.animales.Vaca;
import ejercicioTres.interfaces.Animal;
import ejercicioTres.interfaces.Carnivoro;
import ejercicioTres.interfaces.Herbivoro;

public class Main {
    public static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro)
            ((Carnivoro)animal).comerCarne();
        if(animal instanceof Herbivoro)
            ((Herbivoro) animal).comerHierva();
    }
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.haceSonido();
        perro.comerCarne();

        gato.haceSonido();
        gato.comerCarne();

        vaca.haceSonido();
        vaca.comerHierva();

        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }
}
