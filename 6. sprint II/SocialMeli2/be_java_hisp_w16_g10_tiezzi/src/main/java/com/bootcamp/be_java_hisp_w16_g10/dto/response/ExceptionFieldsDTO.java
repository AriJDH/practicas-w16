package com.bootcamp.be_java_hisp_w16_g10.dto.response;

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
