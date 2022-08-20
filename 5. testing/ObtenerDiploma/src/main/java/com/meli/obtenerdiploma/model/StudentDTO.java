package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre no puede ser vacío.")
    @Pattern(regexp = "[A-Z][a-z]+", message = "El nombre debe comenzar con mayúscula.")
    @Size(max = 50, message = "El nombre no debe superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotNull(message = "Debe incluir al menos una materia")
    List<SubjectDTO> subjects;
}
