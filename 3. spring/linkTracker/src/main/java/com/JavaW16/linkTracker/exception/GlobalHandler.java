package com.JavaW16.linkTracker.exception;

import com.JavaW16.linkTracker.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(LinkNotFound.class)
    public ResponseEntity<ExceptionApiDTO> catchException(LinkNotFound e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(LinkPasswordIncorrect.class)
    public ResponseEntity<ExceptionApiDTO> catchException(LinkPasswordIncorrect e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(LinkIsNotValid.class)
    public ResponseEntity<ExceptionApiDTO> catchException(LinkIsNotValid e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(LinkUrlNotValidated.class)
    public ResponseEntity<ExceptionApiDTO> catchException(LinkUrlNotValidated e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(LinkIdCreated.class)
    public ResponseEntity<ExceptionApiDTO> catchException(LinkIdCreated e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
}
