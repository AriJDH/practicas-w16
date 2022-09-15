package com.example.qatesters.exception;

import com.example.qatesters.dto.ErrorHandlerDTO;
import com.example.qatesters.dto.ExceptionFieldsDTO;
import com.example.qatesters.dto.FieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorHandlerDTO> NotFoundException(Exception e){
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.NOT_FOUND.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FoundException.class)
    public ResponseEntity<ErrorHandlerDTO> FoundException(Exception e){
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.CONFLICT.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({
            UrlNotValidException.class,
            ConstraintViolationException.class,
            MissingServletRequestParameterException.class,
            BadRequestException.class
        })
    public ResponseEntity<ErrorHandlerDTO> UrlNotValidException(Exception e){
        ErrorHandlerDTO errorHandlerDTO = new ErrorHandlerDTO().builder().error(HttpStatus.BAD_REQUEST.value()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorHandlerDTO, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionFieldsDTO methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ExceptionFieldsDTO processFieldErrors(List<FieldError> fieldErrors) {
        return ExceptionFieldsDTO.builder()
                .error(HttpStatus.BAD_REQUEST.value())
                .message("Error de validación.")
                .fields(fieldErrors.stream()
                        .map(error -> new FieldErrorDTO(error.getField(), error.getDefaultMessage()))
                        .collect(Collectors.toList())
                )
                .build();
    }
}
