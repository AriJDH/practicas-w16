package com.bootcamp.blog.exception;

public class BlogEntryNotFoundException extends RuntimeException {
    public BlogEntryNotFoundException(String id) {
        super("La entrada de blog con id " + id + " no existe");
    }
}
