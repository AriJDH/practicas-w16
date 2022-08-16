package com.example.blog.exceptions;

public class IdDuplicatedException extends RuntimeException{
    public IdDuplicatedException() {
    }

    public IdDuplicatedException(String message) {
        super(message);
    }
}
