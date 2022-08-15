package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @Pattern(regexp = "[A-Z]\\\\w*", message = "El nombre de la materia debe comenzar con mayúscula")
    @NotBlank(message = "El nombre de la materia")
    String name;

    @DecimalMin(value = "0.0" ,message = "La mínima nota es 0.0")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0")
    @NotBlank(message = "La nota no puede estar vacía")
    Double score;
}
