package com.tomas.blog.exception;

public class BlogEmptyException extends RuntimeException{

    public BlogEmptyException(){
        super("No existen blogs creados");
    }

}
