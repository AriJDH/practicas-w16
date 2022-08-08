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
  Integer id;
  String titulo;
  String autor;
  String fechaPublicacion;
}
