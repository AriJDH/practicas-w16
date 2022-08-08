package com.bootcamp.links.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException (Integer id){
        super("La URL con id: " + id + " no existe");
    }
}
