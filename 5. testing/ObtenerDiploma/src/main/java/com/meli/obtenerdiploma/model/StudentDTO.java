package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.") @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.") @Pattern(regexp = "[A-ZÀ-Ú][a-zà-ú]*", message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.") @Valid
    List<SubjectDTO> subjects;
}
