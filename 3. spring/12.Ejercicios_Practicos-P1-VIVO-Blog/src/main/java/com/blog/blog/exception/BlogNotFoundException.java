package com.blog.blog.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(Integer id){
        super("This "+id+" doesn't exists ");
    }
}
