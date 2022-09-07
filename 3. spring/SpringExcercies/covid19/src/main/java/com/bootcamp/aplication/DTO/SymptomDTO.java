package com.bootcamp.aplication.DTO;

public class SymptomDTO {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;

    public SymptomDTO() {
    }

    public SymptomDTO(int codigo) {
        this.codigo = codigo;
    }

    public SymptomDTO(int codigo, String nombre, String nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(String nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "Sintomas{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad='" + nivel_de_gravedad + '\'' +
                '}';
    }
}
