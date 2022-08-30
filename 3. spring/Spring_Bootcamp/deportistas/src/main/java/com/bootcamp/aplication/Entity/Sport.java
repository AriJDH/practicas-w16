package com.bootcamp.aplication.Entity;

public class Sport {
    private String nombre;
    private String nivel;

    public Sport() {
    }

    public Sport(String nombre, String nivel) {
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

    @Override
    public String toString() {
        return "{nombre: " + nombre +
                "   nivel: " + nivel + "}";
    }
}
