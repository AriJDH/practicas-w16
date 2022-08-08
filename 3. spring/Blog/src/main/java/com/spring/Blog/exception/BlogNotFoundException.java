package com.spring.Blog.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(int id){
        super("Blog con id: "+id +" no existe");
    }
}
