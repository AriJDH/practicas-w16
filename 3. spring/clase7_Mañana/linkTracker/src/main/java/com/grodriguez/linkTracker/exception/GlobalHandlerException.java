package com.grodriguez.linkTracker.exception;

import com.grodriguez.linkTracker.DTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UrlNotValidException.class)
    public ResponseEntity<ExceptionDTO> notValidException(UrlNotValidException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Url not valid", exception.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notValidException(NotFoundException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Not found", exception.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
