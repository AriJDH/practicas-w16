package com.example.obrasliterarias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras")
public class ObraLiteraria {

    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantPaginas;
    @Field(type = FieldType.Date)
    private Date fechaPublicacion;
    private String editorial;
}
