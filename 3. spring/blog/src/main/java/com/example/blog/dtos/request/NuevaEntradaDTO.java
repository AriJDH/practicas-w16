package com.example.blog.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NuevaEntradaDTO {


    private String titulo;
    private String nombre;
    private String fechaDePublicacion;
}
