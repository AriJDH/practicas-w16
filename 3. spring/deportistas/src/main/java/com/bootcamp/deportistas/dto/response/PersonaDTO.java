package com.bootcamp.deportistas.dto.response;

public class PersonaDTO {
    String nombre;
    String apellido;
    String deporte;

    public PersonaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getDeporte() {
        return this.deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
