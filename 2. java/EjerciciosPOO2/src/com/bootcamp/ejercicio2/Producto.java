package com.bootcamp.ejercicio2;

public class Producto {
  private String nombre;
  private Double precio;

  public String getNombre() {
    return nombre;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Producto(String nombre, Double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Producto {" +
        "nombre='" + nombre + '\'' +
        ", precio=" + precio +
        '}';
  }

  public Double calcular(Integer cantidadDeProductos) {
    return this.precio * cantidadDeProductos;
  }
}
