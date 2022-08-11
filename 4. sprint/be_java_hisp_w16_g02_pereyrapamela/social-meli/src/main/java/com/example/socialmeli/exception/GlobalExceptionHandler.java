package com.example.socialmeli.exception;

import com.example.socialmeli.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(UserNotFoundException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("User not found.", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InputNotValidException.class})
    public ResponseEntity<ExceptionApiDto> catchException(InputNotValidException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Input not valid.", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserAlreadyFollowingException.class})
    public ResponseEntity<ExceptionApiDto> catchException(UserAlreadyFollowingException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Input not valid.", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({FollowerNotFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(FollowerNotFoundException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Input not valid.", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DateIncorrectException.class})
    public ResponseEntity<ExceptionApiDto> catchException(DateIncorrectException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Input not valid.", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }
}
