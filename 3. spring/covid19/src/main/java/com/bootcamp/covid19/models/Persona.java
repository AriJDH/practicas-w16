package com.bootcamp.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
  private Integer id;
  private String nombre;
  private String apellido;
  private Integer edad;
  private List<Sintoma> sintomas;
}