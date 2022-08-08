package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {

    private Integer id;
    private String titulo;
    private String nombre;
    private LocalDate fechaDePublicacion;
}
