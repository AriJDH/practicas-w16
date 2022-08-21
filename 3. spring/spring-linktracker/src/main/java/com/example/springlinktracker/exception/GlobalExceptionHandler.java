package com.example.springlinktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> linkNotFoundException(LinkNotFoundException ex) {
        ExceptionResponseDTO errorResponse = new ExceptionResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkNotAuthorizedException.class)
    public ResponseEntity<ExceptionResponseDTO> linkNotAuthorizatedException(LinkNotAuthorizedException ex) {
        ExceptionResponseDTO errorResponse = new ExceptionResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionResponseDTO> invalidLinkException(InvalidLinkException ex) {
        ExceptionResponseDTO errorResponse = new ExceptionResponseDTO();
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
