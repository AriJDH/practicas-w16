package com.bootcamp.showroom.exception;

import com.bootcamp.showroom.dto.ErrorHandlerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorHandlerDto> NotFoundException(Exception e) {
        return new ResponseEntity<>(
                ErrorHandlerDto.builder()
                        .error(HttpStatus.NOT_FOUND.value())
                        .message(e.getMessage()).build(),
                HttpStatus.NOT_FOUND
        );
    }
}
