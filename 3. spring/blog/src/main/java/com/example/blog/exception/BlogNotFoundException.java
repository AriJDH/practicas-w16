package com.example.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogNotFoundException extends RuntimeException {

    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogNotFoundException(Integer id) {
        super("No se ha encontrado ningún blog con el id: " + id);
        this.htttpStatus = HttpStatus.ALREADY_REPORTED;
        this.exception = "Blog not found exception";
    }
}
