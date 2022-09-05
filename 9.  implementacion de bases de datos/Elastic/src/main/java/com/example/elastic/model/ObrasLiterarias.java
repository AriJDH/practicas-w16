package com.example.elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "ObrasLiterarias")
public class ObrasLiterarias {
    @Id
    private String  id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anoPublicacion;


}
