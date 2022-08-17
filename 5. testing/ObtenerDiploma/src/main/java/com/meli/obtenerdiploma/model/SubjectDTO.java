package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "[A-Z]\\\\w*", message = "El nombre de la materia debe comenzar con mayúscula")
    @Max(value = 50, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @NotEmpty(message = "La nota no puede estar vacia")
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La maxima nota es 10.0")
    Double score;
}
