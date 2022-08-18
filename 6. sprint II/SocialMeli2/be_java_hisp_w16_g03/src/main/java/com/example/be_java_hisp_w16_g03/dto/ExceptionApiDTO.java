package com.example.be_java_hisp_w16_g03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionApiDTO {

    private String title;
    private String message;
    private HashMap<String, List<String>> errors;

    public ExceptionApiDTO(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
