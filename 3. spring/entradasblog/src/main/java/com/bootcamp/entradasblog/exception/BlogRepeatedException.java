package com.bootcamp.entradasblog.exception;

public class BlogRepeatedException extends RuntimeException{

    public BlogRepeatedException ( int id ) {
        super("Blog with id: " + id + " already exists");
    }
}
