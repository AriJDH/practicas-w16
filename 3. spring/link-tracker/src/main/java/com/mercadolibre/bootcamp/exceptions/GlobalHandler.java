package com.mercadolibre.bootcamp.exceptions;

import com.mercadolibre.bootcamp.dtos.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> catchUrlInvalid(InvalidUrlException exception){
        ExceptionDto response = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionDto> catchLinkNotFound(LinkNotFoundException exception){
        ExceptionDto response = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
