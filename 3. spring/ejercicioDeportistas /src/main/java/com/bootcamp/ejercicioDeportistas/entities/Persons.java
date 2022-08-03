package com.bootcamp.ejercicioDeportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
  private String name;
  private String lastName;
  private Integer age;
}
