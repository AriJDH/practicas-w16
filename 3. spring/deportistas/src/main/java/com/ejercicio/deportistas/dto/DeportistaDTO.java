package com.ejercicio.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {

    private String nombre;
    private String apelllido;
    private  String deporte;
}
