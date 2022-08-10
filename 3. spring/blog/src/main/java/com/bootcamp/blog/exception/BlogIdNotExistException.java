package com.bootcamp.blog.exception;

public class BlogIdNotExistException extends RuntimeException{
    public BlogIdNotExistException (String id){
        super("The blogId " + id + " not exist");
    }
}
