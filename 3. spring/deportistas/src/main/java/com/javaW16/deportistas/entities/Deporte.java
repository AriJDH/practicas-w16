package com.javaW16.deportistas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Deporte {

   public Deporte(String nombre) {
      this.nombre = nombre;
   }

   String nombre;
}
