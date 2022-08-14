package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
  @NotBlank(message = "El nombre del alumno no puede estar vacío.")
  @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
  String studentName;
  String message;
  Double averageScore;
  @NotEmpty(message = "La lista no puede ser vacía.")
  List<@Valid SubjectDTO> subjects;
}
