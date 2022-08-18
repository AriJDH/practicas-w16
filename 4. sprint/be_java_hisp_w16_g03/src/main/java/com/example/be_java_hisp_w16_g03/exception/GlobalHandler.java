package com.example.be_java_hisp_w16_g03.exception;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserNotExistException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserExistsException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    //excpecion lanzada cuando el request no pasa el control de validacion
    @ExceptionHandler(InvalidPostRequest.class)
    public ResponseEntity<ExceptionApiDTO> catchException(InvalidPostRequest e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(AlreadyFollowException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NotSellerException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowersException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NotFollowersException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

}
