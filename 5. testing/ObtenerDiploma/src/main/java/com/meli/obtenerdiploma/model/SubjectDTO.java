package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "")
    String name;
    Double score;
}
