package com.bootcamp.blog.exception;

public class BlogAlreadyExistException extends RuntimeException {

    public BlogAlreadyExistException(int id) {super("El blog con ID: "+id+" ya existe");}
}
