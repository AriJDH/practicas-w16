package com.meli.obtenerdiploma.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter@Builder
public class ExceptionFieldsDTO {
    private Integer error;
    private String message;
    private List<FieldErrorDTO> fields;
}
