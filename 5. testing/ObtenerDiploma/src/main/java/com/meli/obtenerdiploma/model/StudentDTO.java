package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank (message = "El nombre del alumno no puede estar vacío")
            @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
            @Pattern(regexp = "[A-Z]\\w*", message = "El nombre del alumno debe comenzar con mayuscula")
    String studentName;


    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacia")
    List<@Valid SubjectDTO> subjects;
}
