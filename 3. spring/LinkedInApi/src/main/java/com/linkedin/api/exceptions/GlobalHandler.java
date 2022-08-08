package com.linkedin.api.exceptions;

import com.linkedin.api.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BadUrlException.class)
    public ResponseEntity<ExceptionDTO> catchExceptionLink(BadUrlException b){

        ExceptionDTO bu = new ExceptionDTO(b.getMessage());

        return new ResponseEntity<>(bu, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> catchExceptionLinkNotFound(NotFoundException b){

        ExceptionDTO bu = new ExceptionDTO(b.getMessage());

        return new ResponseEntity<>(bu, HttpStatus.NOT_FOUND);
    }
}
