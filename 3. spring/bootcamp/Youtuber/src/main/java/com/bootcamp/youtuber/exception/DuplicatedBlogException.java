package com.bootcamp.youtuber.exception;

import org.springframework.http.HttpStatus;

public class DuplicatedBlogException extends RuntimeException{

    private final HttpStatus htttpStatus;
    private final String exception;

    public DuplicatedBlogException(String id) {
        super("Blog con id: " + id + " ya existe");
        this.htttpStatus = HttpStatus.ALREADY_REPORTED;
        this.exception = "Blog duplicado Exception";
    }


}
