package com.bootcamp.be_java_hisp_w16_g06.exceptions;

import com.bootcamp.be_java_hisp_w16_g06.dto.MessageDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(UserNotFoundException.class)

    public ResponseEntity<ResponseDTO> catchUserNotFound(UserNotFoundException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowedNotFoundException.class)
    public ResponseEntity<ResponseDTO> catchFollowedNotFound(FollowedNotFoundException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 404);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(OrdenPostException.class)
    public ResponseEntity<ResponseDTO> catchOrderOPost(OrdenPostException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ResponseDTO> catchFollowException(FollowException e) {
        ResponseDTO exceptionResponse = new ResponseDTO(e.getMessage(), 400);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<MessageDTO> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());

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
        messageDTO.setErrorField(errors);
        return new ResponseEntity<>(messageDTO, HttpStatus.BAD_REQUEST);
    }

}
