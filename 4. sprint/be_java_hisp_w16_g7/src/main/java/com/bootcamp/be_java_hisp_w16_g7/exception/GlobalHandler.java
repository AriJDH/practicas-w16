package com.bootcamp.be_java_hisp_w16_g7.exception;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDto> onUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDto("User Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({PostNotFoundException.class})
    public ResponseEntity<ApiResponseDto> catchException(PostNotFoundException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Not Found", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({FollowsNotFoundException.class})
    public ResponseEntity<ApiResponseDto> catchException(FollowsNotFoundException e) {
        ApiResponseDto apiResponseDto = new ApiResponseDto("Not Found", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserIsNotSellerException.class)
    public ResponseEntity<ApiResponseDto> catchException(UserIsNotSellerException e){
        ApiResponseDto apiResponseDto = new ApiResponseDto("Bad Request", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }
}
