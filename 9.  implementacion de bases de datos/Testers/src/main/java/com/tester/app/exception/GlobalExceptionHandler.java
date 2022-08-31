package com.tester.app.exception;

import com.tester.app.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TestNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onJoyaNotFoundException(TestNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
