package com.diploma.diploma.model;


import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SubjectDTO implements Serializable{
    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[A-Z][A-zÀ-ú]*", message="El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message="La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message="La nota no puede estar vacía.")
    @DecimalMin(value = "0.0", message="La mínima nota es 0.0.")
    @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
    Double score;
}

