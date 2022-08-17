package com.example.obtenerdiploma.model;


import lombok.*;

import javax.validation.constraints.*;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SubjectDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max=30, message = "La longitud del nombre no puede superar los 30 caracteres")
    private String name;
    @NotNull(message = "El score no puede estar vacio")
    @DecimalMax(value = "10.0",  message = "La nota Maxima no puede ser mayor a 10.0")
    @DecimalMin(value = "0.0", message = "La nota Minima no puede ser inferior a 0.0")
    private double score;
}
