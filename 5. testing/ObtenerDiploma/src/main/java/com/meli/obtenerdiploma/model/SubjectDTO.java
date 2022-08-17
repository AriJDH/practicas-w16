package com.meli.obtenerdiploma.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Size(max = 30, message="La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message="El nombre de la materia debe comenzar con mayúscula.")
    String name;
    @NotNull(message="La nota no puede estar vacía.")
    @Min(value = 0, message="La mínima nota es 0.0.")
    @Max(value = 10, message = "La máxima nota es 10.0.")
    Double score;
}
