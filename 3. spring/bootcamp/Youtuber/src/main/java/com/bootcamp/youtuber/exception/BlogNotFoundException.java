package com.bootcamp.youtuber.exception;

import org.springframework.http.HttpStatus;

public class BlogNotFoundException extends RuntimeException{

    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogNotFoundException(String id) {
        super("Blog con id: " + id + " no fue encontrado");
        this.htttpStatus = HttpStatus.NOT_FOUND;
        this.exception = "Blog no encontrado";
    }
}
