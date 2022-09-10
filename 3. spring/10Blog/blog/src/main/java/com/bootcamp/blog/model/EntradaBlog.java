package com.bootcamp.blog.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private String id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

}
