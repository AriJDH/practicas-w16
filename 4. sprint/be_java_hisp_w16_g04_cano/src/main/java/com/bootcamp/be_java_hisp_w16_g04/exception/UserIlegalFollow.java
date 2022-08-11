package com.bootcamp.be_java_hisp_w16_g04.exception;

import org.springframework.http.HttpStatus;

public class UserIlegalFollow extends RuntimeException {
  private final HttpStatus htttpStatus;
  private final String exception;

  public UserIlegalFollow(String message) {
    super(message);
    this.htttpStatus = HttpStatus.BAD_REQUEST;
    this.exception = message;
  }
}