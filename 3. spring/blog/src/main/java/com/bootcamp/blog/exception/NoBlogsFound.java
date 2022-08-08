package com.bootcamp.blog.exception;

public class NoBlogsFound extends RuntimeException {
  public NoBlogsFound() {
    super("No se encontraron blogs");
  }
}
