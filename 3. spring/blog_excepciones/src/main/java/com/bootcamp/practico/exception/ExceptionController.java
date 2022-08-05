package com.bootcamp.practico.exception;

import com.bootcamp.practico.dto.ResponseMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BlogBadRequestException.class)
    public ResponseEntity<?> BlogBadRequestException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessageDto.builder().message(e.getMessage()));
    }

    @ExceptionHandler(BlogCreatedException.class)
    public ResponseEntity<?> BlogCreatedException(Exception e){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseMessageDto.builder().message(e.getMessage()));
    }

    @ExceptionHandler(BlogIdAlreadyCreated.class)
    public ResponseEntity<?> BlogIdAlreadyCreated(Exception e){
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(ResponseMessageDto.builder().message(e.getMessage()));
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> IdNotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ResponseMessageDto.builder().message(e.getMessage()));
    }



}
