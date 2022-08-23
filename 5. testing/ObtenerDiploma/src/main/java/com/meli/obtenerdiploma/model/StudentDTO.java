package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max =50,message = "La logitud del nombre no puede superar los 50 caracteres")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    List<@Valid SubjectDTO> subjects;
}
