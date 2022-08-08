package com.blog.blog.exception;

public class BlogAlreadyExistsException extends RuntimeException {

    public BlogAlreadyExistsException(Integer id){
        super("This Blog already exists "+id);
    }

}
