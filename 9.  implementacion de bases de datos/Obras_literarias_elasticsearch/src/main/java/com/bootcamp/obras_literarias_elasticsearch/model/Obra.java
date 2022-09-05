package com.bootcamp.obras_literarias_elasticsearch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obra")
public class Obra {

    @Id
    private String id;
    private String nombreObra;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}
