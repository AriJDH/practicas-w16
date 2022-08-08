package com.bootcamp.linktacker.exception;

import com.bootcamp.linktacker.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ApiResponseDto> catchException(InvalidUrlException e) {
        ApiResponseDto exceptionApiDTO = new ApiResponseDto("URL invalida", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }
}
