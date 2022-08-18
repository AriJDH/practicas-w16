package com.bootcamp.be_java_hisp_w16_g7.exception;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.DataTypeExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto("User Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidQueryException.class)
    public ResponseEntity<?> InvalidQueryException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler({FollowsNotFoundException.class})
    public ResponseEntity<ApiResponseDto> catchException(FollowsNotFoundException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Not Found", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserIsNotSellerException.class)
    public ResponseEntity<ApiResponseDto> catchException(UserIsNotSellerException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Bad Request", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ApiResponseDto> catchException(AlreadyFollowingException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Already following", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowingException.class)
    public ResponseEntity<ApiResponseDto> catchException(NotFollowingException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Not following", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SameUserException.class})
    public ResponseEntity<ApiResponseDto> catchException(SameUserException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Same user", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);

    }

   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponseDto> handleValidationExceptions(MethodArgumentNotValidException e) {
        ApiResponseDto error = new ApiResponseDto("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<DataTypeExceptionDTO> validatingDataTypes(
            MethodArgumentNotValidException exception
    ) {
        DataTypeExceptionDTO errorDTO = new DataTypeExceptionDTO();
        errorDTO.setTitle("HttpMessageNotReadableException");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST);

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
    protected ResponseEntity<ApiResponseDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ApiResponseDto error = new ApiResponseDto("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
