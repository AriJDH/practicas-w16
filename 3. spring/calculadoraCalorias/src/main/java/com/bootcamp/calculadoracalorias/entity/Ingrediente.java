package com.bootcamp.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {
  private String nombre;
  private Integer calorias;

  @Override
  public String toString() {
    return "Ingrediente{" +
        "nombre='" + nombre + '\'' +
        ", calorias=" + calorias +
        '}';
  }
}