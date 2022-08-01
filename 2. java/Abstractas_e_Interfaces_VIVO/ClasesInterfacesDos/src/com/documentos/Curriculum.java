package com.documentos;

import com.interfaz.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {

    private String nombre, apellido;
    private int identificacion, edad;
    
    private List<String> listaHabilidades= new ArrayList<String>();
    
    public Curriculum(String nombre, String apellido, int identificacion, int edad, List<String> listaHabilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.listaHabilidades = listaHabilidades;
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

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(List<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void imprimir() {
        System.out.println("Se imprimio el curriculum \n" + this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion=" + identificacion +
                ", edad=" + edad +
                ", listaHabilidades=" + listaHabilidades +
                '}';
    }
}
