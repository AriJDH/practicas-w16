package com.bootcamp.empleados.exception;

import com.bootcamp.empleados.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onEmpleadoNotFoundException(EmpleadoNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto("EmpleadoNotFound", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
