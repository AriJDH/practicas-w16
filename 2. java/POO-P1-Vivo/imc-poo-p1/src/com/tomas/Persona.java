package com.tomas;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 * Descripción: Clase que aplica conecptos de POO para calcular
 * el nivel de peso de una persona, de acuerdo al IMC
 */

public class Persona {

    //Inicialización de variables
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //Constructor vacío
    public Persona() {

    }

    //Constructor con parámetros de entrada nombre, edad y dni
    public Persona(String nombre, int edad, String dni) {

        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;

    }

    //Constructor con parámetros de entrada nombre, edad, dni, peso y altura
    public Persona(String nombre, int edad, String dni, double peso, double altura) {

        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;

    }


    //Cálculo del imc de acuerdo a la fórmula
    public int calcularImc() {
        double imc = peso/(Math.pow(2, altura));

        if(imc < 20) {

            return -1;

        } else if(imc >= 20 && imc <= 25) {

            return 0;

        } else {

            return 1;

        }


    }

    //Determina si es mayor de edad o no
    public boolean calcularMayorEdad() {

        if(edad >= 18) {

            return true;

        } else {

            return false;

        }

    }

    //Imprime los datos de la persona
    public String imprimirDatos() {

        String datos = "Nombre: " + nombre + "\nEdad: " + edad
                + "\ndni: " + dni + "\nPeso: " + peso + " kg" + "\nAltura: " + altura + " mts" ;

        return datos;

    }


}
