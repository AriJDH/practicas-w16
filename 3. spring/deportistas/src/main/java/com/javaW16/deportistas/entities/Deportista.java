package com.javaW16.deportistas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Deportista {

   public Deportista(Deporte deporte, Persona persona, String nivel) {
      this.deporte = deporte;
      this.persona = persona;
      this.nivel = nivel;
   }

   Deporte deporte;
   Persona persona;
   String nivel;

}
