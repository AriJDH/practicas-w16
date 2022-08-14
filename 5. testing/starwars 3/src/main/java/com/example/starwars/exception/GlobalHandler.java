package com.example.starwars.exception;

import com.example.starwars.controller.FindController;
import com.example.starwars.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(CharacterNotFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

}
