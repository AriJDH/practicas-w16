package com.bootcamp.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
  private String codigo;
  private String nombre;
  private String nivelDeGravedad;
}