package com.bootcamp.be_java_hisp_w16_g04.exception;

import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseApiDTO> catchException(UserNotFoundException e) {
        ResponseApiDTO exceptionApiDTO = new ResponseApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
