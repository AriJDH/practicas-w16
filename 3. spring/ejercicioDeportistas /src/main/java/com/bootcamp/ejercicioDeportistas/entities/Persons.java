package com.bootcamp.ejercicioDeportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
  private String name;
  private String lastName;
  private Integer age;
}
