package com.bootcamp.ejercicio2.documentos;

import java.util.List;

public class Curriculum{
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
}
