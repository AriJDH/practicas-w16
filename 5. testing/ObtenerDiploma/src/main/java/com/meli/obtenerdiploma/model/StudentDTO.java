package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Max(value = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Min(value = 3, message="La longitud minima es de 3 caracteres")
    @Pattern(regexp = "[A-Z]\\\\w*", message = "El nombre del alumno debe comenzar con mayúscula")
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    String studentName;
    String message;
    Double averageScore;

    List<@NotEmpty(message = "La lista no puede ser vacía") SubjectDTO> subjects;
}
