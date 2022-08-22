package com.meli.be_java_hisp_w16_g5.exceptions;

public class UnknownRequestException extends RuntimeException{
    public UnknownRequestException(String message) {
        super(message);
    }
}
