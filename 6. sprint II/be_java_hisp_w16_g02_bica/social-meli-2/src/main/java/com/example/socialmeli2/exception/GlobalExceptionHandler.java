package com.example.socialmeli2.exception;

import com.example.socialmeli2.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionApiDto> catchException(MethodArgumentNotValidException e) {
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Input not valid: " + e.getFieldError().getField(), e.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

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
}
