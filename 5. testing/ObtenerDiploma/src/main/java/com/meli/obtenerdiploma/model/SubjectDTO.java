package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class SubjectDTO {

    @Max(value = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp = "[A-Z]\\\\w*", message = "El nombre de la materia debe comenzar con mayúscula")
    @NotBlank(message = "El nombre de la materia")
    String name;

    @Min(value = 0 ,message = "La mínima nota es 0.0")
    @Max(value = 10, message = "La máxima nota es 10.0")
    @NotBlank(message = "La nota no puede estar vacía")
    Double score;
}
