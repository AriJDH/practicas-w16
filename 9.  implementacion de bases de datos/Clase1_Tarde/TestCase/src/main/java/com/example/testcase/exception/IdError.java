package com.example.testcase.exception;

import org.springframework.http.HttpStatus;

public class IdError extends Exception{
    public final HttpStatus CODE = HttpStatus.BAD_REQUEST;
    public final String ERROR = "No TestCase found for that id.";
    public IdError() {
        super();
    }
}
