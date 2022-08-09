package com.example.linkTraker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestException> badRequestException(BadRequestException e) {

        BadRequestException badRequestException = new BadRequestException(e.getMessage());

        return new ResponseEntity<>(badRequestException,HttpStatus.BAD_REQUEST);
    }


}
