package com.bootcamp.link.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<?> InvalidUrlException(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR: Ingresó una URL invalida.");
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> LinkNotFoundException(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: El Link no fue encontrado.");
    }

    @ExceptionHandler(InvalidPasswordLinkException.class)
    public ResponseEntity<?> InvalidPasswordLinkException(Exception exception){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ERROR: Sin autorización.");
    }
}
