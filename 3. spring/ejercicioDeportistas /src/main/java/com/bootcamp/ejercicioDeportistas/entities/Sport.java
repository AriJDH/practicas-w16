package com.bootcamp.ejercicioDeportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
  private String name;
  private Integer level;
}
