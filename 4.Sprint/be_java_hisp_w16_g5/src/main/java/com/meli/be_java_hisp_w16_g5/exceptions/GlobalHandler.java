package com.meli.be_java_hisp_w16_g5.exceptions;

import com.meli.be_java_hisp_w16_g5.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> catchUserNotFoundException(UserNotFoundException b){

        ExceptionDto bu = new ExceptionDto(b.getMessage());
        return new ResponseEntity<>(bu, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProducNotFoundException.class)
    public ResponseEntity<ExceptionDto> catchProductNotFoundException(ProducNotFoundException b){

        ExceptionDto bu = new ExceptionDto(b.getMessage());
        return new ResponseEntity<>(bu, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnknownRequestException.class)
    public ResponseEntity<ExceptionDto> catchUnknownRequestException(UnknownRequestException b){

        ExceptionDto bu = new ExceptionDto(b.getMessage());
        return new ResponseEntity<>(bu, HttpStatus.BAD_REQUEST);
    }
}
