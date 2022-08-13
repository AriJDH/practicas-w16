package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@ControllerAdvice
public class GlobalHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ResponseApiDTO> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        ResponseApiDTO responseApiDTO = new ResponseApiDTO();
        responseApiDTO.setTitle("Payload's Field Not Valid Exception");
        responseApiDTO.setStatusCode(HttpStatus.BAD_REQUEST.value());

        HashMap<String, List<String>> errors = new HashMap<>();

        exception
                .getFieldErrors()
                .forEach(
                        e -> {
                            String field = e.getField();
                            String message = e.getDefaultMessage();
                            List<String> errorFields = new ArrayList<>();
                            if (errors.containsKey(field)){
                                errorFields = errors.get(field);
                            }
                            errorFields.add(message);
                            errors.put(field, errorFields);
                        }
                );
        responseApiDTO.setErrorField(errors);
        return new ResponseEntity<>(responseApiDTO, HttpStatus.BAD_REQUEST);
    }
}
