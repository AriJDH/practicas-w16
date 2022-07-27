package com.bootcamp.pruebas;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona( "Eduardo", "78787878", 21);
        Persona persona3 = new Persona( "Eduardo", "78787878", 21, 30, 1.70);

        System.out.println(persona3.calcularIMC());
        System.out.println(persona2.esMayorDeEdad());
    }
}
