package com.tomas.animal;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import com.tomas.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    //Sobreescritura del método comerCarne de la interfaz Carnivoro
    @Override
    public void comerCarne() {

        System.out.println("El gato es un animal carnívoro");
    }

    //Sobreescritura del método  abstracto emitirSonido de la clase heredada Animal
    @Override
    public void emitirSonido() {

        System.out.println("Miau");
    }


}
