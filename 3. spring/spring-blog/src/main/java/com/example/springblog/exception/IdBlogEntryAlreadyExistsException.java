package com.example.springblog.exception;

public class IdBlogEntryAlreadyExistsException extends RuntimeException {
    public IdBlogEntryAlreadyExistsException(Integer id) {
        super("Ya existe una entrada de blog con el id: " + id);
    }
}
