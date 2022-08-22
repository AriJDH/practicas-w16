package com.meli.obtenerdiploma.model;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

@Data
public class ErrorDto {
    private String exception;
    private HttpStatus status;
    private String messageException;
    HashMap<String, List<String>> errors = new HashMap<>();
}
