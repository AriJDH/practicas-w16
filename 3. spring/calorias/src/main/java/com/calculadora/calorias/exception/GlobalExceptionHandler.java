package com.calculadora.calorias.exception;

import com.calculadora.calorias.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> notFoundException(Exception e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionApiDTO, exceptionApiDTO.getStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionApiDTO> badRequestException(RuntimeException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(exceptionApiDTO, exceptionApiDTO.getStatus());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionApiDTO> badRequestException(MissingServletRequestParameterException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Parametro faltante: " + e.getParameterName(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionApiDTO, exceptionApiDTO.getStatus());
    }

}
