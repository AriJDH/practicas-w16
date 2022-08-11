package com.grodriguez.blog.exception;

public class RepeatedException extends RuntimeException{

    public RepeatedException(String message) {
        super(message);
    }
}
