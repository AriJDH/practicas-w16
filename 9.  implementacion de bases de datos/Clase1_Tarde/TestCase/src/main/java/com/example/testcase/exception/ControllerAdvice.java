package com.example.testcase.exception;

import com.example.testcase.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(IdError.class)
    public ResponseEntity<ErrorDTO> noId(IdError ex) {
        HttpStatus code = ex.CODE;
        ErrorDTO error = new ErrorDTO();
        error.setCode(code.value());
        error.setMessage(ex.ERROR);
        return new ResponseEntity<>(error, code);
    }

}
