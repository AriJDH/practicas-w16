package com.deportistas.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomDataNotFoundException extends RuntimeException {  
    private HttpStatus status = null;

    private Object data = null;

    public CustomDataNotFoundException() {
      super();
    }

   public CustomDataNotFoundException(
      String message
   ) { 
      super(message);
   }

    public CustomDataNotFoundException(
        HttpStatus status,
        String message
    ) {
        this(message);
        this.status = status;
    }

    public CustomDataNotFoundException(
        HttpStatus status,
        String message,
        Object data
    ) {
        this(
          status,
          message
        );
        this.data = data;
    }
}
