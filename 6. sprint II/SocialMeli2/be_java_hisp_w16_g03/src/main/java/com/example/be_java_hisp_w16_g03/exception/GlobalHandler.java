package com.example.be_java_hisp_w16_g03.exception;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ExceptionApiDTO> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO();
        exceptionApiDTO.setTitle("Payload's Field Not Valid Exception");
        exceptionApiDTO.setMessage("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception
                .getFieldErrors()
                .forEach(
                        e -> {
                            String field = e.getField();
                            String msg = e.getDefaultMessage();
                            List<String> errorFields = new ArrayList<>();
                            if (errors.containsKey(field)) {
                                errorFields = errors.get(field);
                            }
                            errorFields.add(msg);
                            errors.put(field, errorFields);
                        }
                );
        exceptionApiDTO.setErrors(errors);
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ExceptionApiDTO> recipeNotFoundException3(HttpMessageNotReadableException ex) {
        ExceptionApiDTO exceptionDTO = new ExceptionApiDTO();
        exceptionDTO.setMessage("");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserNotExistException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserExistsException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    //excpecion lanzada cuando el request no pasa el control de validacion
    @ExceptionHandler(InvalidPostRequest.class)
    public ResponseEntity<ExceptionApiDTO> catchException(InvalidPostRequest e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(AlreadyFollowException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotSellerException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NotSellerException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowersException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NotFollowersException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

}
