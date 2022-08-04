package com.bootcamp.deportes.dtos;

import com.bootcamp.deportes.entities.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeporteDTO {
    private String nombre;
    private int nivel;
}
