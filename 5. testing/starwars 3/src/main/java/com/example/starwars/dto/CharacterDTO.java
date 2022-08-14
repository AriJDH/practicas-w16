package com.example.starwars.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO {
  private String name;
  private Integer height;
  private Integer mass;
  private String gender;
  private String homeworld;
  private String species;

}
