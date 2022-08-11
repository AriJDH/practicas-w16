package com.bootcamp.ejercicio2.modelos;

import com.bootcamp.ejercicio2.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {
  private String nombre;
  private List<String> habilidades;


  public String getNombre() {
    return nombre;
  }

  public List<String> getHabilidades() {
    return habilidades;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setHabilidades(List<String> habilidades) {
    this.habilidades = habilidades;
  }

  public Curriculum() {
  }

  public Curriculum(String nombre, List<String> habilidades) {
    this.nombre = nombre;
    this.habilidades = habilidades;
  }

  @Override
  public void imprimir() {
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Hola, soy ")
        .append(this.nombre)
        .append(" este es mi curriculum, y esta es una lista de mias habilidades: ")
        .append(this.habilidades);
    System.out.println(mensaje);
  }
}
