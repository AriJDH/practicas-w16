package com.tomas.excepciones;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 * Descripción: Manejo de excepciones con try catch finally y uso de throw
 */

public class PracticaExcepciones {

    public static void main(String[] args) {

        /*********************
         * Primer Ejercicio
         *********************/
        int a = 0;
        int b = 300;

        try {

            int operacion;
            operacion = b / a;

        } catch (ArithmeticException e) {

            System.out.println("Se ha producido un error");

        } finally {

            System.out.println("Programa finalizado");
        }



        /*********************
         * Segundo Ejercicio
         *********************/
        int c = 0;
        int d = 300;

        try {

            int operacion;

            if(c==0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }

            operacion = d / c;

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        } finally {

            System.out.println("Programa finalizado");
        }

    }

}
