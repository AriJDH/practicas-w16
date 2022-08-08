package com.bootcamp.blog.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(Integer id) {
        super("The blog with id " +id+ " don't exist");
    }
}
