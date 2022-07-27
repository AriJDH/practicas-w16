package Ejercicios;

import java.lang.Math;

public class Persona {
    String nombre;
    int edad;
    char[] dni;
    double peso;
    double altura;

    public Persona(){

    }
    public Persona(String nombre, int edad, char[] dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, char[] dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        int valor = 0;
            double IMC = peso/Math.pow(altura,2);
            if (IMC<20) {
                valor = -1;
            }
            else if(IMC>=20 && IMC<=25){
                valor= 0;
            }
            else if (IMC>25){
                valor = 1;
            }
        return valor;
    }

    public boolean esMayorDeEdad(){
        boolean dato = false;
        if (edad>=18){
            dato = true;
        }
        return dato;
    }
    public String toString(){
        String informacion = "Nombre: "+nombre+", Edad: "+edad+", DNI: "+String.valueOf(dni)+", Peso: "+peso+", Altura: "+altura;
        return informacion;
    }
}
