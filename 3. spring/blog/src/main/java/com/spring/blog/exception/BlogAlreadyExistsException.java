package com.spring.blog.exception;

public class BlogAlreadyExistsException extends RuntimeException{
    public BlogAlreadyExistsException(Integer id){ super("Ya existe un blog registrado con el id: " + id); }
}
