package com.example.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class EntradaNotFoundDTO {

    String name;
    String message;
    List<String> listaDeErrores;

    HashMap<String, List<String>> errors;
    public EntradaNotFoundDTO ( String name, String message ) {
        this.name    = name;
        this.message = message;
    }

    public EntradaNotFoundDTO ( String name, List<String> listErrors ) {
        this.name       = name;
        this.listaDeErrores = listErrors;
    }

    public EntradaNotFoundDTO ( String name, HashMap<String, List<String>> errors ) {
        this.name         = name;
        this.errors       = errors;
    }

}
