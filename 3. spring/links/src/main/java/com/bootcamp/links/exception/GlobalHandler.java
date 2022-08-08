package com.bootcamp.links.exception;

import com.bootcamp.links.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler({NoMatchException.class})
    public ResponseEntity<ExceptionApiDto> catchException(NoMatchException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("No Match", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(NotFoundException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotValidException.class})
    public ResponseEntity<ExceptionApiDto> catchException(NotValidException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Not Valid", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({PasswordMissmatchException.class})
    public ResponseEntity<ExceptionApiDto> catchException(PasswordMissmatchException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Password Missmatch", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
}
