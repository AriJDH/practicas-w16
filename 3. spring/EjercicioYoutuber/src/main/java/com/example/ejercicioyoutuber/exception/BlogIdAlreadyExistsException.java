package com.example.ejercicioyoutuber.exception;

import org.springframework.http.HttpStatus;

public class BlogIdAlreadyExistsException extends RuntimeException{

    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogIdAlreadyExistsException() {
        super("This Blog id already exists");
        this.htttpStatus = HttpStatus.CONFLICT;
        this.exception = "Already Exists";
    }
}
