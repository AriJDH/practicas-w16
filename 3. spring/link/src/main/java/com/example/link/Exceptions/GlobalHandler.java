package com.example.link.Exceptions;

import com.example.link.dto.ResponseApiDto;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandler {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ResponseApiDto> catchException(InvalidLinkException e){

    }
}
