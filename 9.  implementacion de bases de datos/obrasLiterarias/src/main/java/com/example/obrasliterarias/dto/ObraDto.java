package com.example.obrasliterarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraDto {

    private String nombre;
    private String autor;
    private Integer cantPaginas;
    private Date fechaPublicacion;
    private String editorial;
}
