package com.example.ejblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fecha;
}
