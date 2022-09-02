package com.example.ejeerciciobiblioteca.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ObraLiterariaDto {
    private String id;
    private String nombre;
    private String autor;
    private Integer cantPaginas;
    private String editorial;
    private Integer anioPublicacion;
}

