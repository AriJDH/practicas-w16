package com.mercadolibre.bootcamp.exceptions;

import com.mercadolibre.bootcamp.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(DuplicatedEntryException.class)
    public ResponseEntity<ExceptionDto> catchExceptionDuplicated(DuplicatedEntryException e) {
        ExceptionDto exceptionDto = new ExceptionDto("Duplicated entry", e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<ExceptionDto> catchExceptionNotFound(EntryNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto("Entry not found", e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
