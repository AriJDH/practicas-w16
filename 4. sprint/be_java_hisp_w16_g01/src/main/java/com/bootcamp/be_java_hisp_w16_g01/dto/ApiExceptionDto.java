package com.bootcamp.be_java_hisp_w16_g01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiExceptionDto {
    private String title;
    private String message;
}
