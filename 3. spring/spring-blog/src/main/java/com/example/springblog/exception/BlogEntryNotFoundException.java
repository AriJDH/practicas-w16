package com.example.springblog.exception;

public class BlogEntryNotFoundException extends RuntimeException {
    public BlogEntryNotFoundException(Integer id) {
        super("No hay una entrada de blog con el id: " + id);
    }
}
