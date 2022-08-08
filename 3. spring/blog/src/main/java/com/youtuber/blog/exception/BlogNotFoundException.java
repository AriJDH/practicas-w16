package com.youtuber.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogNotFoundException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogNotFoundException(Integer id) {
        super("Blog con id: " + id + " no existe");
        this.htttpStatus = HttpStatus.ALREADY_REPORTED;
        this.exception = "Blog not found exception";
    }
}
