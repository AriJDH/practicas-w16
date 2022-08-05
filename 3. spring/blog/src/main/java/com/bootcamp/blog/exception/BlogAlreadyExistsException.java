package com.bootcamp.blog.exception;

public class BlogAlreadyExistsException extends RuntimeException{
    public BlogAlreadyExistsException() {
    }

    public BlogAlreadyExistsException(String message) {
        super(message);
    }
}
