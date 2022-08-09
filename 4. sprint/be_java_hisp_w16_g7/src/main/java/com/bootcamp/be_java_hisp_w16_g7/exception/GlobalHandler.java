package com.bootcamp.be_java_hisp_w16_g7.exception;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(UserIsNotSellerException.class)
    public ResponseEntity<ApiResponseDto> catchException(UserIsNotSellerException userIsNotSeller){
        ApiResponseDto apiResponseDto = new ApiResponseDto(userIsNotSeller.getMessage(),"User is not a seller");
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND);
    }
}
