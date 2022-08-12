package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @Valid
    @NotEmpty(message = "El nombre del alumno no debe estar vacío")
    @Size(message = "La longitud del nombre no puede superar los 50 caracteres", max = 50)
    @Pattern(regexp = "([A-Z|Ñ|Á|Ó|É|Í|Ú])[\\s|A-Z|a-z|Ñ|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}
