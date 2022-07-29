package com.tomas.documentos;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

public class Informe implements Impresion{

    private String texto;
    private int cantidadPagina;
    private String autor;
    private String revisor;

    //Constructor que recibe los atributos para la clase Informe
    public Informe(String texto, int cantidadPagina, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPagina = cantidadPagina;
        this.autor = autor;
        this.revisor = revisor;
    }

    //Métodos getters y setters

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    //Método sobreescrito de la interfaz Impresion para imprimir los datos del informe
    @Override
    public void imprimir() {

        System.out.println("------------Informe------------");
        System.out.println("Cantidad de páginas: " + cantidadPagina);
        System.out.println("Nombre del autor: " + autor);
        System.out.println("Nombre del revisor: " + revisor);
        System.out.println("Texto: " + texto);


    }
}
