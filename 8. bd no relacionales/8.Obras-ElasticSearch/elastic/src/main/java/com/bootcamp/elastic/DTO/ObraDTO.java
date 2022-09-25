package com.bootcamp.elastic.DTO;

import lombok.Data;

@Data
public class ObraDTO {
    private String id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
