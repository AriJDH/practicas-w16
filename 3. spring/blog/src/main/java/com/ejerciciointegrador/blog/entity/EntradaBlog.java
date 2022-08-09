package com.ejerciciointegrador.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private long id;
    private String tituloDelBlog;
    private String nombreDelAutor;
    private Date fechaDePublicacion;

}
