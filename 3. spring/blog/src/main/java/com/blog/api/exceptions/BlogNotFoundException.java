package com.blog.api.exceptions;

public class BlogNotFoundException extends Exception{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
