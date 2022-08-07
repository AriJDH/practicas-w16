package com.example.ejblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
