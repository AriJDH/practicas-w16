package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "No puede ser nulo")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$",
            message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max= 30, message = "El nombre no puede tener una longitud superior a 30")
    String name;

    @NotNull(message = "No puede ser nulo")
    @DecimalMin(value = "0.0", message = "El puntaje mínimo es 0")
    @DecimalMax(value = "10.0", message = "La nota máxima es 10")
    Double score;
}
