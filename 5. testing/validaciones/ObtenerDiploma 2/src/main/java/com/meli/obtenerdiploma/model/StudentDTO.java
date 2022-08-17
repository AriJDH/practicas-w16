package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentDTO {

    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @NotBlank(message = "El nombre del alumno no puede estar vacio.")
    //@Pattern(regexp = "^[a-z]", flags = Pattern.Flag.MULTILINE, message = "El nombre del alumno debe comenzar con mayuscula")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "La lista no puede estar vacia")
    List<@Valid SubjectDTO> subjects;
}
