package com.example.demo.DTOs;

import java.io.Serializable;

public class DeporteDTO implements Serializable {
    private String nombre;
    private String nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
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
}
