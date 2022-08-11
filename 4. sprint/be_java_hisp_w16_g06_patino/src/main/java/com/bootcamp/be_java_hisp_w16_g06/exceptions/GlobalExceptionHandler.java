package com.bootcamp.be_java_hisp_w16_g06.exceptions;

import com.bootcamp.be_java_hisp_w16_g06.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> catchUserNotFound(UserNotFoundException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowedNotFounException.class)
    public ResponseEntity<ResponseDTO> catchFollowedNotFound(FollowedNotFounException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrdenPostException.class)
    public ResponseEntity<ResponseDTO> catchOrderOPost(OrdenPostException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ResponseDTO> catchFollowException(FollowException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
