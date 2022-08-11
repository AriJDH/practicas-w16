package com.bootcamp.ejercicioDeportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportDto {
  private String name;
  private Integer level;
}
