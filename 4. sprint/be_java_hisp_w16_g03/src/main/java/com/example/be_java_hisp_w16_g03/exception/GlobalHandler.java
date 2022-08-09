package com.example.be_java_hisp_w16_g03.exception;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NotFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO();
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }

    //excpecion lanzada cuando el request no pasa el control de validacion
    @ExceptionHandler(InvalidPostRequest.class)
    public ResponseEntity<ExceptionApiDTO> catchException(InvalidPostRequest e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
