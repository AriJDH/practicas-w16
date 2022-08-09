package com.bootcamp.deportistas.model;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String deporte;

    public Persona (){}

    public Persona(String nombre, String apellido, Integer edad, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDeporte() {
        return this.deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
