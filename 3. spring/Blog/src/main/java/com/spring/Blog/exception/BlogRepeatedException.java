package com.spring.Blog.exception;

public class BlogRepeatedException extends RuntimeException{

    public BlogRepeatedException(int id){
        super("Blog con id: "+id +" ya existe");
    }
}
