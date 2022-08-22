package com.bootcamp.be_java_hisp_w16_g04.exception;

public class UserIlegalFollow extends RuntimeException {

  public UserIlegalFollow(String message) {
    super(message);
  }
}