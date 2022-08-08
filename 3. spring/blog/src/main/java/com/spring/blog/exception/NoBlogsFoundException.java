package com.spring.blog.exception;

public class NoBlogsFoundException extends RuntimeException{
    public NoBlogsFoundException(){ super("No se encontraron entradas de blog registradas."); }
}
