package com.bootcamp.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
  private String nombre;
  private String apellido;
  private Integer edad;
  private List<String> sintomas;
}