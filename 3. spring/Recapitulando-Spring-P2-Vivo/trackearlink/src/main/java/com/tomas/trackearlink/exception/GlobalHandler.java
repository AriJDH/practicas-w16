package com.tomas.trackearlink.exception;

import com.tomas.trackearlink.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchUrlInvalid(InvalidUrlException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchLinkNotFound(LinkNotFoundException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchLinkInactiveFound(LinkInactiveException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchInvalidPassword(PasswordException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
