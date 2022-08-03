package com.example.deportista.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

   private String nombre;
   private  String Apellido;
   private   int edad;
   private  Deporte deporte;




}
