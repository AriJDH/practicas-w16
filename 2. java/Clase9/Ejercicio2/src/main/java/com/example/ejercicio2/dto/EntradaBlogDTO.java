package com.example.ejercicio2.dto;

import com.example.ejercicio2.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

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
