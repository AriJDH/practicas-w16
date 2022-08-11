package com.bootcamp.linktracer.exception;

import com.bootcamp.linktracer.dto.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<ResponseApiDTO> onLinkNotFoundException(LinkNotFoundException e) {
        return new ResponseEntity<>(new ResponseApiDTO("Not found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ResponseApiDTO> onIncorrectPasswordException(IncorrectPasswordException e) {
        return new ResponseEntity<>(new ResponseApiDTO("Unauthorized", e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ResponseApiDTO> onInvalidUrlException(InvalidUrlException e) {
        return new ResponseEntity<>(new ResponseApiDTO("Bad request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
