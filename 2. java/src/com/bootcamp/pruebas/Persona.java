package com.bootcamp.pruebas;

public class Persona {

    String nombre;
    String dni;
    Integer edad;
    double peso;
    double altura;


    public Persona() {

    }

    public Persona(String nombre, String dni, Integer edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, Integer edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public boolean esMayorDeEdad (){
        return this.edad>=18;
    }

    public int calcularIMC() {
        double valueIMC = this.peso/Math.pow(this.altura, 2);

        if(valueIMC < 20){
            System.out.println("Bajo peso");
            return -1;
        }else if(valueIMC >= 20 && valueIMC <= 25){
            System.out.println("Peso Saludable");
            return 0;
        }else {
            System.out.println("Sobre peso");
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}