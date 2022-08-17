package com.meli.obtenerdiploma.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.obtenerdiploma.util.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = ErrorMessage.NOMBRE_ALUMNO_VACIO)
    @Pattern(regexp = "[A-ZÀ-Ú][a-zà-ú]*", message = ErrorMessage.NOMBRE_ALUMNO_SINCAP)
    @Max(value = 50, message = ErrorMessage.NOMBRE_ALUMNO_MAX)
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = ErrorMessage.LISTA_VACIA)
    List<SubjectDTO> subjects;
}
