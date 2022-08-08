package com.javaW16.startWars.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Personaje {

   private String name;
   private int height;
   private int mass;
   private String hairColor;
   private String skinColor;
   private String eyeColor;
   private String birthYear;
   private String gender;
   private String homeWorld;
   private String species;

}
