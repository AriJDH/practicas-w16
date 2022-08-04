package com.bootcamp.starwarsexcercise.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Character {

   private String name;
   private Integer height;
   private Integer mass;
   private String hairColor;
   private String skinColor;
   private String eyeColor;
   private String birthYear;
   private String gender;
   private String homeWorld;
   private String species;

}
