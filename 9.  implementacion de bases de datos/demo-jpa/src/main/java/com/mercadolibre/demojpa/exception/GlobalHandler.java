package com.mercadolibre.demojpa.exception;

import com.mercadolibre.demojpa.dto.ResponseExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseExceptionDTO> notFoundException(Exception e){
        ResponseExceptionDTO exceptionDTO = new ResponseExceptionDTO("Don't found the resource", e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

}
