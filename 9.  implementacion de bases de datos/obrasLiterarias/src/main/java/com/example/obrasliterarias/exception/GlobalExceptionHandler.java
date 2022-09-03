package com.example.obrasliterarias.exception;

import com.example.obrasliterarias.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObraNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onEmpleadoNotFoundException(ObraNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto("EmpleadoNotFound", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
