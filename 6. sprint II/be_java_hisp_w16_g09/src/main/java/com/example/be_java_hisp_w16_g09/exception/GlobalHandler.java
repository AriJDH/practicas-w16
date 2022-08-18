package com.example.be_java_hisp_w16_g09.exception;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<MessageDto> catchUserNotFound(UserNotFoundException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MessageDto> catchUserIsNotSellerException(UserToFollowIsNotSellerException exception) {
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

    @ExceptionHandler(UserNotFollowing.class)
    public ResponseEntity<MessageDto> UserNotFollowing(UserNotFollowing exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserDoesNotFollowedAnyone.class)
    public ResponseEntity<MessageDto> UserDoesNotFollowedAnyone(UserDoesNotFollowedAnyone exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotAllowedToFollowException.class)
    public ResponseEntity<MessageDto> UserNotAllowedToFollowException(UserNotAllowedToFollowException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<MessageDto> InvalidDateException(InvalidDateException exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderNotExist.class)
    public ResponseEntity<MessageDto> OrderNotExist(OrderNotExist exception) {
        MessageDto response = new MessageDto(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<MessageDto> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        MessageDto errorDTO = new MessageDto();
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
}
