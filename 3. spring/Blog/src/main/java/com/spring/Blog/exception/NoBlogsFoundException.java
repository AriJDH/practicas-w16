package com.spring.Blog.exception;

public class NoBlogsFoundException extends RuntimeException{

    public NoBlogsFoundException (){
        super("No hay blogs creados");
    }
}
