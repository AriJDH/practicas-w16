package com.example.elasticvivo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "obras")
public class Obra {

    @Id
    private String id;
    private String autor;
    private String nombreObra;
    private Integer cantPaginas;
    private String editorial;
    private Integer anhoPublicacion;

}
