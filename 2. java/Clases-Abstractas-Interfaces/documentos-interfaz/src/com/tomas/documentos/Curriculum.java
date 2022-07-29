package com.tomas.documentos;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import java.util.ArrayList;

public class Curriculum implements Impresion{

    private int identificacion;
    private String nombre;
    private String apellido;
    private String profesion;
    private int edad;
    private String empresaUltimoEmpleo;
    private ArrayList habilidad;


    //Constructor que recibe los atributos para la clase curriculum
    public Curriculum(int identificacion, String nombre, String apellido, String profesion, int edad, String empresaUltimoEmpleo, ArrayList habilidad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.edad = edad;
        this.empresaUltimoEmpleo = empresaUltimoEmpleo;
        this.habilidad = habilidad;
    }

    //Métodos getters an setters

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmpresaUltimoEmpleo() {
        return empresaUltimoEmpleo;
    }

    public void setEmpresaUltimoEmpleo(String empresaUltimoEmpleo) {
        this.empresaUltimoEmpleo = empresaUltimoEmpleo;
    }

    public ArrayList getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(ArrayList habilidad) {
        this.habilidad = habilidad;
    }

    //Método sobreescrito de la interfaz Impresion para imprimir los datos del curriculum
    @Override
    public void imprimir() {

        System.out.println("------------Curriculum------------");
        System.out.println("Identificación: " + identificacion);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Profesión: " + profesion);
        System.out.println("Edad: " + edad);
        System.out.println("Último empleo en: " + empresaUltimoEmpleo);
        System.out.println("Habilidades: " + habilidad);


    }
}
