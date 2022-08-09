package com.example.ejercicioyoutuber.exception;

import com.example.ejercicioyoutuber.dto.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandler {

    @ExceptionHandler(BlogIdAlreadyExistsException.class)
    public ResponseEntity<ResponseApiDto> catchException(BlogIdAlreadyExistsException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Blog ID already in use");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BlogIdNotFoundException.class)
    public ResponseEntity<ResponseApiDto> catchException(BlogIdNotFoundException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Blog entry not found");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
