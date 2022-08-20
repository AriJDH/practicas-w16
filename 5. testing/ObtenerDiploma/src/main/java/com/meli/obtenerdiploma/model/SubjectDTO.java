package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "[A-Z][a-z]+", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "El nombre no debe superar los 30 caracteres.")
    private String name;

    @NotNull(message = "La nota debe ser vacío.")
    @DecimalMin(value="0.0", message = "La nota mínima es 0.0.")
    @DecimalMax(value="10.0", message = "La nota máxima es 10.0.")
    private Double score;
}
