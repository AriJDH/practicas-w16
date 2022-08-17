package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "[A-Z][^A-Z]*", message = "El nombre de la materia debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @Min(message = "La mínima nota es 0.0", value = 0)
    @Max(message = "La máxima nota es 10.0", value = 10)
    @NotNull(message = "La nota no puede estar vacía")
    Double score;
}
