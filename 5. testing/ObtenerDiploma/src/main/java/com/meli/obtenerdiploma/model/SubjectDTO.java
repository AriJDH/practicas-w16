package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
  @NotBlank(message = "El nombre de la materia no puede estar vacío.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  String name;
  @NotNull(message = "La nota no puede estar vacía.")
  @Min(value = 0, message = "La mínima nota es 0.0.")
  @Max(value = 10, message = "La máxima nota es 10.0.")
  Double score;
}
