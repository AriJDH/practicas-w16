package com.bootcamp.SocialMeli2.controller;
import com.bootcamp.SocialMeli2.dto.response.ResponseApiDto;
import com.bootcamp.SocialMeli2.dto.response.ValidateFieldExceptionDto;
import com.bootcamp.SocialMeli2.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandler {
    @ExceptionHandler()
    public ResponseEntity<ResponseApiDto> catchUserNotFollowException(UserNotFolllowException e) {
        ResponseApiDto exceptionDTO = new ResponseApiDto(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseApiDto> catchException(UserNotFoundException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("User was not found");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotVendorException.class)
    public ResponseEntity<ResponseApiDto> catchUserNotVendorException(UserNotVendorException e){
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("User not vendor");
        return  new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowAUserException.class)
    public  ResponseEntity<ResponseApiDto> catchAlreadyFollowAUserException(AlreadyFollowAUserException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Already follow this user");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CanNotFollowYourSelfException.class)
    public  ResponseEntity<ResponseApiDto> catchCanNotFollowYourSelfException(CanNotFollowYourSelfException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Can not follow yourself");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderNotPossibleException.class)
    public  ResponseEntity<ResponseApiDto> catchOrderNotPossibleException(OrderNotPossibleException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("That sorting order is not valid");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidateFieldExceptionDto> validatingDataTypes(MethodArgumentNotValidException exception) {
        ValidateFieldExceptionDto errorDTO = new ValidateFieldExceptionDto();

        errorDTO.setException("Datos incorrectos");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST);
        errorDTO.setMessageException("Los datos ingresados no son correctos");

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
        errorDTO.setErrors(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public  ResponseEntity<ResponseApiDto> catchHttpMessageNotReadableException(HttpMessageNotReadableException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Formato del Json incorrecto");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }
}
