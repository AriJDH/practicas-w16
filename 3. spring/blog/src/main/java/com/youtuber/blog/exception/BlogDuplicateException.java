package com.youtuber.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogDuplicateException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public BlogDuplicateException(Integer id) {
        super("Blog con id: " + id + " ya existe");
        this.htttpStatus = HttpStatus.ALREADY_REPORTED;
        this.exception = "Blog duplicate Exception";
    }
}
