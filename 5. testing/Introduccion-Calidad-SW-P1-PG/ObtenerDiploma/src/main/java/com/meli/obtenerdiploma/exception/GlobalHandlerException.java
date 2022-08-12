package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandlerException extends RuntimeException {

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
                            if (errors.containsKey(field)){
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
