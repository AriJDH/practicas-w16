package com.deportistas.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
class CustomControllerAdvice {

  @ExceptionHandler(CustomDataNotFoundException.class)
  public ResponseEntity<?> handleCustomDataNotFoundException(
    CustomDataNotFoundException exception
  ) {
    HttpStatus status = HttpStatus.NOT_FOUND; // 404

    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    //exception.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();
    System.out.println("Hey");
    return new ResponseEntity<>(
      new ErrorResponse(status, "Aqui hay un error", stackTrace, exception.getData()),
      status
    );
  }
}
