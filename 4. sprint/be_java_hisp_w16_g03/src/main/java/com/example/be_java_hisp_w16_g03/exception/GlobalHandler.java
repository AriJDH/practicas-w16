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
    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserNotExistException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found",e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
