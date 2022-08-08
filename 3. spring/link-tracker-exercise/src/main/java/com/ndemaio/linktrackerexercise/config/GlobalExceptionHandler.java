package com.ndemaio.linktrackerexercise.config;

import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import com.ndemaio.linktrackerexercise.exception.LinkUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.MalformedURLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity linkNotFoundException(LinkNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(LinkUnauthorizedException.class)
    public ResponseEntity linkUnauthorizedException(LinkUnauthorizedException linkUnauthorizedException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(linkUnauthorizedException);
    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity malformedUrlException(MalformedURLException malformedURLException){
        return ResponseEntity.badRequest().body(malformedURLException);
    }

}
