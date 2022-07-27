/*
    Author: Tannia Lucía Hernández Rojas
    Descripción: Ejercicios de Programación Orientada a Objeto.
                Crear una clase persona con atributos y métodos.
    Fecha: 27 de Julio de 2022
*/

package Ejercicios;

public class Main {
    public static void main(String[] args) {

        //Instancia los objetos de la clase Persona
        Persona persona1 = new Persona();
        char[] dni_1 = {'1', '2', '6', '7', '8', '3'};
        Persona persona2 = new Persona("Marcos", 28, dni_1);
        char[] dni_2 = {'7', '8', '4', '1', '2', '5'};
        Persona persona3 = new Persona("Marcos", 28, dni_2, 50.2, 1.56);

        //Imprime toda la información
        System.out.println(persona3.toString());

        //Identifica el estado de la persona según el cálculo del índice de masa corporal
        int valor = persona3.calcularIMC();
        String estado = "";
        if (valor==-1){
            estado = "Bajo peso";
        }
        else if (valor==0){
            estado = "Peso saludable";
        }
        else{
            estado = "Sobrepeso";
        }
        System.out.println(persona3.nombre+" se encuentra en estado: "+estado);

        //Identifica si la persona es mayor o menor de edad por medio del método esMayordeEdad
        boolean mayor_edad =persona3.esMayorDeEdad();

        if (mayor_edad){
            System.out.println(persona3.nombre+" es mayor de edad");
        }
        else{
            System.out.println(persona3.nombre+" es menor de edad");
        }
    }

}
