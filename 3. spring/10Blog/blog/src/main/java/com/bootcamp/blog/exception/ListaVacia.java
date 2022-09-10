package com.bootcamp.blog.exception;

public class ListaVacia extends RuntimeException{

    public ListaVacia(String msjError){
        super(msjError);//toma el constructor de lruntime
    }
}
