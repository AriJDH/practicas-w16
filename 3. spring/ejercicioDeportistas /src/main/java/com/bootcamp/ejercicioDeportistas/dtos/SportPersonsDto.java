package com.bootcamp.ejercicioDeportistas.dtos;

import com.bootcamp.ejercicioDeportistas.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonsDto {
  private String name;
  private String lastName;
  private Integer age;
  private Sport sport;
}
