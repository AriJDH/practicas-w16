package com.bootcamp.blog.exception;

public class BlogIdExistException extends RuntimeException{
    public BlogIdExistException (String id){
        super("The blogId " + id + " already exist");
    }
}
