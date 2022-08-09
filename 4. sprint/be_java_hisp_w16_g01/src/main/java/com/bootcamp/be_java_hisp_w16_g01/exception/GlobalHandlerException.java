package com.bootcamp.be_java_hisp_w16_g01.exception;

import com.bootcamp.be_java_hisp_w16_g01.dto.ApiExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e){
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
