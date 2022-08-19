package com.bootcamp.be_java_hisp_w16_g01.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionDTO {
    private String title;
    private String message;
    private HashMap<String, List<String>> errorFields;

    public ApiExceptionDTO(String title, String message) {
        this.title = title;
        this.message = message;
        this.errorFields = new HashMap<>();
    }
}
