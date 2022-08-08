package com.example.ejercicio2.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreDelAutor;
    private String fecha;

}
