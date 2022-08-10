package com.bootcamp.be_java_hisp_w16_g04.exception;

import com.bootcamp.be_java_hisp_w16_g04.dto.FollowUserDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ResponseApiDTO> catchException(UserNotFoundException e) {
    ResponseApiDTO exceptionApiDTO = new ResponseApiDTO("Not Found", e.getMessage());
    return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserIlegalFollow.class)
  public ResponseEntity<FollowUserDTO> catchExeption(UserIlegalFollow e) {
    FollowUserDTO followUserDTO = new FollowUserDTO(e.getMessage());
    return new ResponseEntity<>(followUserDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(FailedToCreateResource.class)
  public ResponseEntity<ResponseApiDTO> catchExeptionFailed(FailedToCreateResource e) {
    return new ResponseEntity<>(new ResponseApiDTO("Failed","Failed to create resource"), HttpStatus.BAD_REQUEST);
  }

}
