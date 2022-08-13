package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jdk.jfr.ContentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO
{
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "[A-ZÀ-Ú][a-zà-ú]*", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    @NotNull(message = "La nota no puede estar vacía.")
    @Max(value = 10, message = "La máxima nota es 10.0.")
    @Min(value =0, message = "La minima nota es 0.0")
    @PositiveOrZero(message = "La nota debe ser positiva o cero.")
    Double score;
}
