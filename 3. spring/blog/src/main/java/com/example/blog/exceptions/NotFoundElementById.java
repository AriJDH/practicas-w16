package com.example.blog.exceptions;

public class NotFoundElementById extends RuntimeException{

    public NotFoundElementById() {
    }

    public NotFoundElementById(String message) {
        super(message);
    }
}
