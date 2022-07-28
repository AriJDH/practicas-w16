package com.tomas.animal;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import com.tomas.interfaces.Carnivoro;
import com.tomas.interfaces.Herviboro;

public class Main {


    public static void main(String[] args) {

        System.out.println("---- Animal Perro ----");
        Perro objPerro = new Perro();
        objPerro.emitirSonido();
        objPerro.comerCarne();

        System.out.println();
        System.out.println("---- Animal Gato ----");
        Gato objGato = new Gato();
        objGato.emitirSonido();
        objGato.comerCarne();

        System.out.println();
        System.out.println("---- Animal Vaca ----");
        Vaca objVaca = new Vaca();
        objVaca.emitirSonido();
        objVaca.comerHierba();

        System.out.println();
        System.out.println("---- Según el tipo de animal ----");
        comerAnimal(objPerro);
        comerAnimal(objGato);
        comerAnimal(objVaca);


    }

    //Metodo estatico comer Animal que recibe al objeto del animal correspondiente
    public static void comerAnimal(Animal tipoAnimal){

        //Identifica con qué interfaz está implementada cada animal
        if(tipoAnimal instanceof Herviboro){

            ((Herviboro) tipoAnimal).comerHierba();

        } else if (tipoAnimal instanceof Carnivoro) {

            ((Carnivoro) tipoAnimal).comerCarne();

        }


    }

}
