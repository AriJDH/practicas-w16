package com.example.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentDTO {
    @NotBlank(message = "El nombre del estudiante no puede estar vacio")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50 , message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    private String message;
    private double averageScore;
    @NotEmpty(message = "La lista no puede estar vacia")
    List<SubjectDTO> subjects;
}
