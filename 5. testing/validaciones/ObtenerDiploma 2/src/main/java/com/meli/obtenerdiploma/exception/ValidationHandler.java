package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ValidationExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ValidationExceptionDTO> handleValidationException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ValidationExceptionDTO(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
