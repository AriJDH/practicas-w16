package com.spring.blog.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(Integer id){ super("No se pudo encontrar el blog con id: " + id); }
}
