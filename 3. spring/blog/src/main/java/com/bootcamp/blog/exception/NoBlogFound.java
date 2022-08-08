package com.bootcamp.blog.exception;

public class NoBlogFound extends RuntimeException {
  public NoBlogFound(Integer id){
    super("No se encontro ningun blogs con el id: " + id);
  }
}
