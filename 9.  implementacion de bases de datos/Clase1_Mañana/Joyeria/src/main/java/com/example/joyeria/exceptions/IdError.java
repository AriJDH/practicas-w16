package com.example.joyeria.exceptions;

import org.springframework.http.HttpStatus;

public class IdError extends Exception{
    public final HttpStatus CODE = HttpStatus.BAD_REQUEST;
    public final String ERROR = "No joya found for that id.";
    public IdError() {
        super();
    }
}
