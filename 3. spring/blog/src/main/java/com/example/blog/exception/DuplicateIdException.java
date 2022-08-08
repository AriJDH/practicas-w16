package com.example.blog.exception;

import org.springframework.http.HttpStatus;

public class DuplicateIdException extends RuntimeException{

    private final HttpStatus htttpStatus;
    private final String exception;

    public DuplicateIdException(Integer id) {
        super("Ya existe una entrada de Blog con el id: "+id);
        this.htttpStatus = HttpStatus.ALREADY_REPORTED;
        this.exception = "Duplicate id Exception";
    }
}
