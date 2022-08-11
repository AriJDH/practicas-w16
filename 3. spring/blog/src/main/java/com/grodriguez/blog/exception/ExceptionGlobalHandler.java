package com.grodriguez.blog.exception;

import com.grodriguez.blog.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionGlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(e.getMessage()));
    }

    @ExceptionHandler(RepeatedException.class)
    public ResponseEntity<MessageDTO> repeatedException(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDTO(e.getMessage()));
    }
}
