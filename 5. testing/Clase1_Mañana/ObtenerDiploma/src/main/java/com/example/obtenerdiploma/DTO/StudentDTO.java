package com.example.obtenerdiploma.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotNull(message = "El nombre del Alumno no puede ser vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(min = 1, max = 50,message = "La longitud del nombre no puede superar los 50 caracteres")
    private String studentName;
    @NotEmpty
    private List< @Valid SubjectDTO> subjects;
}
