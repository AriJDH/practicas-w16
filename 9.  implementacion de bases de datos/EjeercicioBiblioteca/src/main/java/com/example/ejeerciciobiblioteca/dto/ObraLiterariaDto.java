package com.example.ejeerciciobiblioteca.dto;

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

    private Integer cantDePaginas;
    private String editorial;
    private Integer anioPrimeraPublicacion;
}

