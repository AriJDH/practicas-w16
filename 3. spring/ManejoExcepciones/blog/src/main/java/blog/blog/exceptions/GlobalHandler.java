package blog.blog.exceptions;

import blog.blog.dtos.ResponseApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogIlegalId.class)
    public ResponseEntity<ResponseApiDTO> catcException(BlogIlegalId e){
        ResponseApiDTO exceptionApiDTO = new ResponseApiDTO("Failed",e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ResponseApiDTO> catchException(BlogNotFoundException e) {
        ResponseApiDTO exceptionApiDTO = new ResponseApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
