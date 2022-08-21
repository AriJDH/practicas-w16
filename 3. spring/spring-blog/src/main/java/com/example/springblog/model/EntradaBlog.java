package com.example.springblog.model;

import lombok.*;

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
