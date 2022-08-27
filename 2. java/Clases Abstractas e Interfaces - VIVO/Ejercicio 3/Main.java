package interfaces3;

import interfaces3.clases.Animal;
import interfaces3.clases.Gato;
import interfaces3.clases.Perro;
import interfaces3.clases.Vaca;

import java.util.Optional;

public class Main {
    public static void main(String[]args){

        Perro perro = new Perro("Firulais", "Carnivoro");
        Vaca vaca = new Vaca("Lola", "Herviboro");
        Gato gato = new Gato("Nala","Carnivoro");

        perro.emitirSonido();
        perro.comerCarne();

        gato.comerCarne();
        gato.emitirSonido();

        vaca.comerHierba();
        vaca.emitirSonido();





    }

}
