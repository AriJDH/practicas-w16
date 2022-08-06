package com.tomas.blog.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(Integer message) {
        super("No existe El blog con el id " + message);
    }

}
