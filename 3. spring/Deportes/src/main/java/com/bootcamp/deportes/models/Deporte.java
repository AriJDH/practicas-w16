package com.bootcamp.deportes.models;

import java.io.Serializable;
import java.util.List;

public class Deporte implements Serializable {

    private String nombre;
    private String nivel;
    private List<Persona> personas;

    public Deporte(String nombre, String nivel, List<Persona> personas) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.personas = personas;
    }

    public Deporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
