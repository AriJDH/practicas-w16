package com.bootcamp.be_java_hisp_w16_g7.exception;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO> onUserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new ApiResponseDTO("User Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidQueryException.class)
    public ResponseEntity<?> InvalidQueryException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler({FollowsNotFoundException.class})
    public ResponseEntity<ApiResponseDTO> catchException(FollowsNotFoundException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserIsNotSellerException.class)
    public ResponseEntity<ApiResponseDTO> catchException(UserIsNotSellerException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Bad Request", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ApiResponseDTO> catchException(AlreadyFollowingException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Already following", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowingException.class)
    public ResponseEntity<ApiResponseDTO> catchException(NotFollowingException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Not following", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SameUserException.class})
    public ResponseEntity<ApiResponseDTO> catchException(SameUserException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Same user", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDiscountException.class)
    public ResponseEntity<ApiResponseDTO> catchException(InvalidDiscountException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Invalid Discount", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductWithPromoFalseException.class)
    public ResponseEntity<ApiResponseDTO> catchException(ProductWithPromoFalseException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Invalid Discount", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductWithPromoWithPastDateException.class)
    public ResponseEntity<ApiResponseDTO> catchException(ProductWithPromoWithPastDateException e) {
        ApiResponseDTO apiResponseDto = new ApiResponseDTO("Invalid Date", e.getMessage());
        return new ResponseEntity<>(apiResponseDto, HttpStatus.BAD_REQUEST);
    }
}
