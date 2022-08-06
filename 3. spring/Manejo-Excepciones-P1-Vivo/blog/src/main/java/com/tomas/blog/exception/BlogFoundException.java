package com.tomas.blog.exception;


public class BlogFoundException extends RuntimeException{

    public BlogFoundException(Integer message) {
        super("El blog con el id " + message + " ya existe");
    }
}
