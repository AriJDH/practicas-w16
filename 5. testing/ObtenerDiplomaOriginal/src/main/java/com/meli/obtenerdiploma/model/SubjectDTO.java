package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.util.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = ErrorMessage.NOMBRE_MATERIA_VACIO)
    @Pattern(regexp = "[A-ZÀ-Ú][a-zà-ú]*", message = ErrorMessage.NOMBRE_MATERIA_SINCAP)
    @Max(value = 30, message = ErrorMessage.NOMBRE_MATERIA_MAX)
    String name;

    @NotEmpty(message = ErrorMessage.NOTA_VACIA)
    @Min(value = 0, message = ErrorMessage.NOTA_MINIMA)
    @Max(value = 10, message = ErrorMessage.NOTA_MINIMA)
    Double score;
}
