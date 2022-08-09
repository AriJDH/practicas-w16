package com.example.ejercicioyoutuber.exception;

import org.springframework.http.HttpStatus;

public class BlogIdNotFoundException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogIdNotFoundException() {
        super("Blog not found");
        this.htttpStatus = HttpStatus.NOT_FOUND;
        this.exception = "Not Found";
    }
}
