package com.bootcamp.obras_literarias.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras_literarias")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ObrasLiterarias {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;
}
