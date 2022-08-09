package com.bootcamp.deportistas.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Deportista {
    private String nombre;
    private String apellido;
    private int edad;

    private String deporte;
    private String nivel;

    public Deportista(String nombre, String apellido, int edad, String deporte, String nivel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
        this.nivel = nivel;
    }


    @Override
    public String toString() {
        return "Deportista{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", deporte='" + deporte + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}
