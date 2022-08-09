package com.ejerciciointegrador.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {

    private Long id;
    private String tituloDelBlog;
    private String nombreDelAutor;
    private Date fechaDePublicacion;
}
