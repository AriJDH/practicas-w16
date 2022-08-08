package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

  @ExceptionHandler(NoBlogsFound.class)
  public ResponseEntity<ExceptionApiDTO> catchException(NoBlogsFound e) {
    ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
    return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NoBlogFound.class)
  public ResponseEntity<ExceptionApiDTO> catchException(NoBlogFound e) {
    ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
    return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
  }
}
