package com.bootcamp.aplication.Entity;

public class Person {
    private String nombre;
    private String apellido;
    private int edad;

    private Sport sport;

    public Person() {
    }

    public Person(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Person(String nombre, String apellido, int edad, Sport sport) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sport = sport;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
