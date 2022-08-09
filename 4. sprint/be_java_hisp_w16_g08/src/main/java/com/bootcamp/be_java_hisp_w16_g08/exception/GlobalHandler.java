package com.bootcamp.be_java_hisp_w16_g08.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandler {

    /*
    @ExceptionHandler(BlogIdAlreadyExistsException.class)
    public ResponseEntity<ResponseApiDto> catchException(BlogIdAlreadyExistsException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Blog ID already in use");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

     */
}
