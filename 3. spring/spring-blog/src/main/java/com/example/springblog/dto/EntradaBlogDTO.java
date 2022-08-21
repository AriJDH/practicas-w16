package com.example.springblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombreDelAutor;
    private String fecha;
}
