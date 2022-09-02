package com.example.practicajoyeria.exception;

import com.example.practicajoyeria.dto.JewelryNotFoundResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class JewelryExceptionHandler {

    @ExceptionHandler(JewelryNotFoundException.class)
    public ResponseEntity<JewelryNotFoundResponseDTO> handleJewelryNotFoundException(JewelryNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JewelryNotFoundResponseDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }
}
