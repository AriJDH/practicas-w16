package com.bootcamp.be_java_hisp_w16_g01_Morales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiExceptionDTO {
    private String title;
    private String message;
}
