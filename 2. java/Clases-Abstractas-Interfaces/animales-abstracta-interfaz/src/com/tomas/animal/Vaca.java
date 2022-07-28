package com.tomas.animal;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */


import com.tomas.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {

    //Sobreescritura del método comerCarne de la interfaz Herviboro
    @Override
    public void comerHierba() {
        System.out.println("La vaca es un animal hervíboro");
    }

    //Sobreescritura del método  abstracto emitirSonido de la clase heredada Animal
    @Override
    public void emitirSonido() {
        System.out.println("muu");
    }

}
