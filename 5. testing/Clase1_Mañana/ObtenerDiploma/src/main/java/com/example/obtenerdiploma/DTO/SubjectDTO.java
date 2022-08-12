package com.example.obtenerdiploma.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @Size(min = 1,max = 30 , message = "La longitud del nombre de la Asignatura no puede superar los 30 caracteres")
    private String name;
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La maxima nota es 10.0")
    private double score;
}
