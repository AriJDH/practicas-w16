package com.bootcamp.aplication.DTO;

public class PersonSportDTO {
    private String nombre;
    private String apellido;
    private String sportName;

    public PersonSportDTO() {
    }

    public PersonSportDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PersonSportDTO(String nombre, String apellido, String sportName) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sportName = sportName;
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

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return
                "nombre: " + nombre + "   " + apellido +
                        ", sportName: " + sportName;
    }
}
