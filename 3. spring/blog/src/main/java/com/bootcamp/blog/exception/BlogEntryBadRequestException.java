package com.bootcamp.blog.exception;

public class BlogEntryBadRequestException extends RuntimeException {
    public BlogEntryBadRequestException(String id) {
        super("Ya existe una entrada con id " + id);
    }
}
