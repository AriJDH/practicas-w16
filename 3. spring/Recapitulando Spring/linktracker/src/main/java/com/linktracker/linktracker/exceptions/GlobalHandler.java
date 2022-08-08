package com.linktracker.linktracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalHandler {
    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ErrorResponse> linkNotFoundException(LinkNotFoundException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponse errorResponse = new ErrorResponse(status, ex.getMessage());
        errorResponse.setData(ex.getLink());
 
        return new ResponseEntity<ErrorResponse>(errorResponse, status);
    }

    @ExceptionHandler(LinkNotAuthorizatedException.class)
    public ResponseEntity<ErrorResponse> linkNotAuthorizatedException(LinkNotAuthorizatedException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponse errorResponse = new ErrorResponse(status, ex.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, status);
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ErrorResponse> invalidLinkException(InvalidLinkException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = new ErrorResponse(status, ex.getMessage());
        errorResponse.setData(ex.getLink());

        return new ResponseEntity<ErrorResponse>(errorResponse, status);
    }
}
