package Interfaces2.models;

import Interfaces2.interfaces.Documento;

import java.util.LinkedList;

public class Persona implements Documento {
    private String nombre;
    private int edad;
    private String carrera;
    private String apellido;
    private LinkedList<String> skills;

    public Persona(String nombre, int edad, String carrera, String apellido, LinkedList<String> skills) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.apellido = apellido;
        this.skills = skills;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", carrera='" + carrera + '\'' +
                ", apellido='" + apellido + '\'' +
                ", skills=" + skills +
                '}';
    }

    @Override
    public void imprimirDocumento(String doc) {
        System.out.println(doc);
    }
}
