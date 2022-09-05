package com.example.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "obras_literarias")
public class ObrasLiterarias {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;


}
