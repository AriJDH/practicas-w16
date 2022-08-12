package com.bootcamp.be_java_hisp_w16_g01_rodriguez.exception;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.ApiExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiExceptionDTO> badRequestException(BadRequestException e){
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiExceptionDTO> missingParamException(){
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", "Verifique los parametros enviados"), HttpStatus.BAD_REQUEST);
    }
}
