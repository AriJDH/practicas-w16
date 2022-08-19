package com.bootcamp.be_java_hisp_w16_g01.exception;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.ApiExceptionDTO;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiExceptionDTO> badRequestException(BadRequestException e){
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiExceptionDTO> missingParamException(){
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", "No hay un orden indicado"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ApiExceptionDTO> handleValidationException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ApiExceptionDTO("Bad request", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiExceptionDTO> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(new ApiExceptionDTO("Argument missmatch", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    ResponseEntity<ApiExceptionDTO> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        ApiExceptionDTO errorDTO = new ApiExceptionDTO();
        errorDTO.setTitle("Payload's Field Not Valid Exception");
        errorDTO.setMessage("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception
                .getFieldErrors()
                .forEach(
                        e -> {
                            String field = e.getField();
                            String msg = e.getDefaultMessage();
                            List<String> errorFields = new ArrayList<>();
                            if (errors.containsKey(field)){
                                errorFields = errors.get(field);
                            }
                            errorFields.add(msg);
                            errors.put(field, errorFields);
                        }
                );
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    ResponseEntity<ApiExceptionDTO> constraintViolationException(
            ConstraintViolationException exception
    ) {
        ApiExceptionDTO errorDTO = new ApiExceptionDTO();
        errorDTO.setTitle("constraintViolationException");
        errorDTO.setMessage("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception
                .getConstraintViolations()
                .forEach(
                        e -> {
                            String field = ((PathImpl) e.getPropertyPath()).getLeafNode().getName();
                            String msg = e.getMessage();
                            List<String> errorFields = new ArrayList<>();
                            if (errors.containsKey(field)){
                                errorFields = errors.get(field);
                            }
                            errorFields.add(msg);
                            errors.put(field, errorFields);
                        }
                );
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
