package com.main;

import com.clases.Animal;
import com.clases.Gato;
import com.clases.Perro;
import com.clases.Vaca;
import com.interfaces.Carnivoros;
import com.interfaces.Herviboros;

public class Main {
    public static void main(String[] args) {
        Gato objGato = new Gato();
        Perro objPerro = new Perro();
        Vaca objVaca = new Vaca();

        objGato.emitirSonido();
        comerAnimal(objGato);

        objVaca.emitirSonido();
        comerAnimal(objVaca);

        objPerro.emitirSonido();
        comerAnimal(objPerro);
    }

    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoros){ // condicion para saber si es carnivoro el tipo de obj que resive por parametro
            ((Carnivoros)animal).comerCarne(); // para castear para usar los metodos de carnivoros
        } else if (animal instanceof Herviboros) {
            ((Herviboros)animal).comerHierba();
            System.out.println(((Herviboros)animal).getClass().getSimpleName());
        }
    }
}
