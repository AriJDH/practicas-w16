package com.deportistas.dto;

import java.io.Serializable;

public class DeportistaDTO implements Serializable{
    private String deporte;
    private String nombre;
    private String apellido;

    public String getDeporte() {
        return this.deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
