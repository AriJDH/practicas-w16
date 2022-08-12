package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z]+[a-zA-Z]*$", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String studentName;

    private String message;

    private Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;
}
