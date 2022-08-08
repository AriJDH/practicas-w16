package com.bootcamp.linktacker.exception;

import org.springframework.http.HttpStatus;

public class InvalidUrlException extends RuntimeException {

    private final HttpStatus htttpStatus;
    private final String exception;

    public InvalidUrlException(Integer id) {
        super("La URL con id: "+ id + " es ivalida");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "URL invalida";
    }
}
