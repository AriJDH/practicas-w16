package com.javaW16.linkTraker.exception;

import java.io.IOException;
import java.net.MalformedURLException;

import com.javaW16.linkTraker.dto.ErrorDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

   @ExceptionHandler(MalformedURLException.class)
   public ResponseEntity<ErrorDto> malformedURLException(Exception e) {
      ErrorDto errorDTO = new ErrorDto("Formato Invalido", e.getMessage());
      return new ResponseEntity<>(errorDTO, HttpStatus.NOT_ACCEPTABLE);
   }

   @ExceptionHandler(IOException.class)
   public ResponseEntity<ErrorDto> noUrlResponse(Exception e) {
      ErrorDto errorDTO = new ErrorDto("La url no responde", e.getMessage());
      return new ResponseEntity<>(errorDTO, HttpStatus.REQUEST_TIMEOUT);
   }

   @ExceptionHandler(UrlAlreadyExistException.class)
   public ResponseEntity<ErrorDto> urlAlreadyExist(Exception e) {
      ErrorDto errorDTO = new ErrorDto("La url ya existe", e.getMessage());
      return new ResponseEntity<>(errorDTO, HttpStatus.OK);
   }

   @ExceptionHandler(IdNotFoundException.class)
   public ResponseEntity<ErrorDto> idNotFound(Exception e) {
      ErrorDto errorDTO = new ErrorDto("Id not found", e.getMessage());
      return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

   }

   @ExceptionHandler(BadPasswordException.class)
   public ResponseEntity<ErrorDto> badPassword(Exception e){
      ErrorDto errorDTO = new ErrorDto("Unauthorized", e.getMessage());
      return new ResponseEntity<>(errorDTO, HttpStatus.UNAUTHORIZED);

   }

}
