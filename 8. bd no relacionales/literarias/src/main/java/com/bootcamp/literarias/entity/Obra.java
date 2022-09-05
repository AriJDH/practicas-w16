package com.bootcamp.literarias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obras")
public class Obra {

    @Id
    private String id;

    public Obra(String nombre, String autor, Integer cantidadPaginas, String editorial, Integer anioPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }

    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
