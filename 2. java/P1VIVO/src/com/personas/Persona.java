package com.personas;

public class Persona {
    protected String nombre;
    protected int edad, dni;
    protected double peso, altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, int dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double IMC = (peso/(Math.pow(altura,2))) - (peso-altura);

        if (IMC < 20 ){
            return -1;
        } else if (IMC >= 20 && IMC <= 25) {
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    @Override
    public String toString() {
        return "Persona: " +
                "nombre=" + nombre +
                ", edad=" + edad +
                ", dni=" + dni +
                ", peso=" + peso +
                ", altura=" + altura;
    }
}
