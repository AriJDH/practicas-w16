package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter

public class StudentDTO {
    
    
    @Size(max = 50, message="La longitud del nombre no puede superar los 50 caracteres.")
    @NotEmpty(message="El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message="El nombre del alumno debe comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message="La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
