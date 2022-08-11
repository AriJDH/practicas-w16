package com.bootcamp.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
