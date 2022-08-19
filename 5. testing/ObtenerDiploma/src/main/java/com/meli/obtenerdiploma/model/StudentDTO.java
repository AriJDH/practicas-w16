package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede ser vacio")
    @Pattern(regexp = "[A-Z]\\\\w*", message = "El nombre del alumno debe comenzar con mayúscula")
    @Max(value = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacia")
    List<@Valid SubjectDTO> subjects;
}
