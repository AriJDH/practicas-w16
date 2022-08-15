package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
ResponseEntity<ExceptionDto> catchExeptionDto(MethodArgumentNotValidException e){
    ExceptionDto ex = new ExceptionDto("Error en la solicitud recibida",e.getBindingResult().getFieldError().getDefaultMessage());
    return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
}


}
