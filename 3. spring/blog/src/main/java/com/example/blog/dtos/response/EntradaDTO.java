package com.example.blog.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntradaDTO {


    private Integer id;
    private String titulo;
    private String nombre;
    private String fechaDePublicacion;
}
