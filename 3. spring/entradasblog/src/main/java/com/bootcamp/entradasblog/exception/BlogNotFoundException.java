package com.bootcamp.entradasblog.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException ( int id ) {
        super("Blog not found with id: " + id);
    }

}
