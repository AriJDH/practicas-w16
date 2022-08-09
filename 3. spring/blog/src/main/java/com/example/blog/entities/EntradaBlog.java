package com.example.blog.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String nombre;
    private String fechaDePublicacion;
}
