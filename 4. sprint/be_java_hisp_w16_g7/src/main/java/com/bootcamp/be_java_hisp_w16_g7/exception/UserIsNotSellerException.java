package com.bootcamp.be_java_hisp_w16_g7.exception;

public class UserIsNotSellerException extends RuntimeException{
    public UserIsNotSellerException(String apiResponseDto) {
        super(apiResponseDto);
    }
}
