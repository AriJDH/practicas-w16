package com.example.qatesters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ExceptionFieldsDTO {
    private Integer error;
    private String message;
    private List<FieldErrorDTO> fields;
}
