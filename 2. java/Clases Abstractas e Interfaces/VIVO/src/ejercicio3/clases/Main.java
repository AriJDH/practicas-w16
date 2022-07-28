package ejercicio3.clases;

import ejercicio3.interfaces.Carnivoro;
import ejercicio3.interfaces.Herviboro;

public class Main {

    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else {
            ((Herviboro)animal).comerHierba();
        }
    }

    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();

        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();

        System.out.println("\n comerAnimal(gato)");
        comerAnimal(gato);

        System.out.println("\n comerAnimal(perro)");
        comerAnimal(perro);

        System.out.println("\n comerAnimal(vaca)");
        comerAnimal(vaca);
    }
}
