package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter@Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "[A-Z][a-z]*", message = "El nombre del alumno debe comenzar con mayúscula.")
    private String studentName;
    private String message;
    private Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<SubjectDTO> subjects;
}
