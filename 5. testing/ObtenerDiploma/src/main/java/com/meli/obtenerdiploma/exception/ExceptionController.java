package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.MessageExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageExceptionDTO> handleValidationException(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();
        String message = fieldErrorList.stream().map(fieldError -> fieldError.getDefaultMessage()).findFirst().get();
        MessageExceptionDTO messageExceptionDTO = new MessageExceptionDTO(message);
        return new ResponseEntity<>(messageExceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
