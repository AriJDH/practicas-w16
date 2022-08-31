package com.example.lasperlas.exception;

import com.example.lasperlas.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onJoyaNotFoundException(JoyaNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto("JoyaNotFound", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
