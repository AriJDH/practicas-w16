package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.MsjErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(BusquedaBlogNotFound.class)
    public ResponseEntity<MsjErroDTO> catchException (BusquedaBlogNotFound busquedaBlogNotFound){
        MsjErroDTO msjErroDTO = new MsjErroDTO(busquedaBlogNotFound.getMessage(),"Not Found");
        return new ResponseEntity<>(msjErroDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ListaVacia.class)
    public ResponseEntity<MsjErroDTO> catchException (ListaVacia listaVacia){
        MsjErroDTO msjErroDTO = new MsjErroDTO(listaVacia.getMessage(),"List is Empty");
        return new ResponseEntity<>(msjErroDTO, HttpStatus.NOT_FOUND);
    }

}
