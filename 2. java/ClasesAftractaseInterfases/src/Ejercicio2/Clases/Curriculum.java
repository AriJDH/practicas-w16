package Ejercicio2.Clases;

import Ejercicio2.Interfaces.Imprimir;

public class Curriculum implements Imprimir {
    private String nombre;
    private String apellido;
    private int edad;
    private int numero;

    public Curriculum(String nombre, String apellido, int edad, int numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void realizarImprecion() {
        System.out.println("Imprimir Curriculums enlistados");
    }
}
