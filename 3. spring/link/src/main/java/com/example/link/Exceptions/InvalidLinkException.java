package com.example.link.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkException implements RuntimeException{
    private final HttpStatus httpStatus;
    private final String exception;

    public InvalidLinkException(){

    }
}
