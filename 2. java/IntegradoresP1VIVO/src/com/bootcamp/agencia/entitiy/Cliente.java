package com.bootcamp.agencia.entitiy;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;

    public Cliente(){}

    public Cliente(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return  "id= " + id + "\n" +
                "nombre= " + nombre  + "\n" +
                "apellido=" + apellido + "\n" ;
    }
}

