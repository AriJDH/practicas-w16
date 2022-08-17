package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionFieldsDTO;
import com.meli.obtenerdiploma.model.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionFieldsDTO methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ExceptionFieldsDTO processFieldErrors(List<FieldError> fieldErrors) {
        return ExceptionFieldsDTO.builder()
                .error(HttpStatus.BAD_REQUEST.value())
                .message("Error de validación.")
                .fields(fieldErrors.stream()
                        .map(error -> new FieldErrorDTO(error.getField(), error.getDefaultMessage()))
                        .collect(Collectors.toList())
                )
                .build();
    }

}