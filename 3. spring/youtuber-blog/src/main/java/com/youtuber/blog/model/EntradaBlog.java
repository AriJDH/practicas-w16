package com.youtuber.blog.model;


import lombok.*;

@Getter
@Setter

public class EntradaBlog {
    public Long id;
    public String titulo, nombre, fechaPublicacion;

    public EntradaBlog(Long id, String titulo, String nombre, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }
}
