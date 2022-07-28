package com.tomas;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 * Descripción: Clase principal donde se crean los objetos
 * y se instancia la clase Persona
 */

public class Main {

    public static void main(String[] args) {

        //Creación de objeto e instancia de la clase Persona
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Tomas", 23, "1075");

        Persona personaTres = new Persona("Mateo", 32, "10905", 80.4, 1.80);
        System.out.println(personaTres.imprimirDatos());

        if(personaTres.calcularMayorEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }


        int nivelPeso = personaTres.calcularImc();
        if(nivelPeso == -1) {
            System.out.println("Nivel de peso: Bajo peso");
        } else if(nivelPeso == 0) {
            System.out.println("Nivel de peso: Peso saludable");
        } else {
            System.out.println("Nivel de peso: Sobrepeso");
        }


        //Persona personaCuatro = new Persona("Juan", 21);
        //No se puede crear personaCuatro
        //El problema está en que no existe un constructor que reciba la cantidad de parámetros pasados


    }
}
