package com.bootcamp.starwars.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonajeDto {
  private String name;
  private int heigh;
  private int mass;
  private String gender;
  private String homeWorld;
  private String species;
}
