package com.calculadora.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ExceptionApiDTO {

    private String message;
    private HttpStatus status;

}
