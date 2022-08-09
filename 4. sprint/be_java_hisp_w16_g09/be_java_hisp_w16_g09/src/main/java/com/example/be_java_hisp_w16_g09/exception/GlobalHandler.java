package com.example.be_java_hisp_w16_g09.exception;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<MessageDto> catchUserNotFound(UserNotFoundException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MessageDto> catchUserAlreadyFollowedException(UserAlreadyFollowedException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UserHasNoFollowersException.class)
    public ResponseEntity<MessageDto> UserHasNoFollowersException(UserHasNoFollowersException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
