package com.main;

import com.personas.Persona;

public class Main {
    public static void main(String[] args) {
        Persona objPersona1 = new Persona();
        Persona objPersona2 = new Persona("nombre", 23, 132422);
        System.out.println("_------------_");
        Persona objPersona3 = new Persona("nombre", 24, 3242223, 56, 1.72);

        System.out.println("" +
                "Es mayor de edad: " + (objPersona3.esMayorDeEdad()?"Si":"No"));

        int personaIMC = objPersona3.calcularIMC();
        String tipoPeso;

        if (personaIMC == -1){
            tipoPeso = "Bajo Peso";
        } else if (personaIMC == 0) {
            tipoPeso = "Peso Saludable";
        }else {
            tipoPeso = "Sobrepeso";
        }

        System.out.println("" +
                "IMC:" + tipoPeso +
                "\n_-----------------_");



    }
}
