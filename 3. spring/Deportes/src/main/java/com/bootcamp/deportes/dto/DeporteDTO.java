package com.bootcamp.deportes.dto;

import com.bootcamp.deportes.models.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class DeporteDTO {

    private String nombre;
    private String nivel;

    @JsonIgnore
    private List<Persona> personas;

    public DeporteDTO(String nombre, String nivel, List<Persona> personas) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.personas = personas;
    }

    public DeporteDTO() {
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
