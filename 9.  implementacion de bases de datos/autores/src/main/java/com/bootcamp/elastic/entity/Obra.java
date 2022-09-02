package com.bootcamp.elastic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "obras")
public class Obra {

    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
