package com.diploma.diploma.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentDTO{

    Long id;
    
    @NotEmpty(message="El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "^[A-Z][A-zÀ-ú]*", message="El nombre del alumno debe comenzar con mayúscula.")
    @Size(max = 50, message="La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message="La lista no puede ser vacía.")
    List<@Valid SubjectDTO> subjects;
}