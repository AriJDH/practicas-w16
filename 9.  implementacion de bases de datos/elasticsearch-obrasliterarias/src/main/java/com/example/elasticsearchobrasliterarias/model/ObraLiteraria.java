package com.example.elasticsearchobrasliterarias.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obrasliterarias")
public class ObraLiteraria {
    @Id
    private String id;
    private String obra;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}
