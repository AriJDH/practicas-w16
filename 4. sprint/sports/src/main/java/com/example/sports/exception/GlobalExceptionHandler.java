package com.example.sports.exception;


import com.example.sports.dto.response.ErrorHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorHandlerDTO> NotFoundException(Exception e) {
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.NOT_FOUND.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FoundException.class)
    public ResponseEntity<ErrorHandlerDTO> FoundException(Exception e) {
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.CONFLICT.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({UrlNotValidException.class, ConstraintViolationException.class, MissingServletRequestParameterException.class, BadRequestException.class})
    public ResponseEntity<ErrorHandlerDTO> UrlNotValidException(Exception e) {
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.BAD_REQUEST.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.BAD_REQUEST);
    }
}
