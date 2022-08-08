package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
  //Mi DTO y mi modelo tienen los mismos datos (En el ejercicio no se me pidio no usar algun dato)
  //Esta bien usar todos los datos del modelo?
  Integer id;
  String titulo;
  String autor;
  String fechaPublicacion;
}
