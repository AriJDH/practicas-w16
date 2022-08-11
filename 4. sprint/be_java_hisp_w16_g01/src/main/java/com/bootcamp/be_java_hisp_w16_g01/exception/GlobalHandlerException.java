package com.bootcamp.be_java_hisp_w16_g01.exception;

import com.bootcamp.be_java_hisp_w16_g01.dto.ApiExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiExceptionDto> badRequestException(BadRequestException e){
        return new ResponseEntity<>(new ApiExceptionDto("Bad request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiExceptionDto> missingParamException(){
        return new ResponseEntity<>(new ApiExceptionDto("Bad request", "No hay un orden indicado"), HttpStatus.BAD_REQUEST);
    }
}
