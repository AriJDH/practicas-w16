package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    //@Pattern(regexp = "^[a-z]", flags = Pattern.Flag.MULTILINE, message = "El nombre del alumno debe comenzar con mayuscula")
    String name;

    @NotNull(message = "La nota no puede estar vacia")
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La maxima nota es 10.0")
    Double score;
}
