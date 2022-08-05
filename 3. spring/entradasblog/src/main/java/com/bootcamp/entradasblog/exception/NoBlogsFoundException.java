package com.bootcamp.entradasblog.exception;

public class NoBlogsFoundException extends RuntimeException{

    public NoBlogsFoundException () {
        super("No se encontraron blogs");
    }
}
