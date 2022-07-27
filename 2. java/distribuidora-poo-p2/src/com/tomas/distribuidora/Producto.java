package com.tomas.distribuidora;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 */

public class Producto {

    private String nombre;
    private double precio;

    //Constructor de la clase
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Métodos getter and setter

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //Método que calcula el valor de los productos multiplicando precio con su cantidad
    public double calcular(int cantidadDeProductos){
        double valor = precio * cantidadDeProductos;

        return valor;
    }

}
