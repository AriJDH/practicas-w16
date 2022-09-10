package com.bootcamp.blog.exception;

public class BusquedaBlogNotFound extends RuntimeException{//en tiempo de ejecución, no tiene try catch, no es chequeable

    public BusquedaBlogNotFound(String msjError){
        super(msjError);//toma el constructor de lruntime
    }

}
