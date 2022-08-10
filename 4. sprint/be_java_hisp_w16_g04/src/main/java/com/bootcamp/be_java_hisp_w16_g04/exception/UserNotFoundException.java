package com.bootcamp.be_java_hisp_w16_g04.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
  private final HttpStatus htttpStatus;
  private final String exception;

  public UserNotFoundException(String message) {
    super(message);
    this.htttpStatus = HttpStatus.NOT_FOUND;
    this.exception = message;
  }
}
