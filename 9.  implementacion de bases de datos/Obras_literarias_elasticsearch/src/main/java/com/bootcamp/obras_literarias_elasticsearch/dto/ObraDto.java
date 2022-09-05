package com.bootcamp.obras_literarias_elasticsearch.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraDto {

    private String id;
    private String nombreObra;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}
