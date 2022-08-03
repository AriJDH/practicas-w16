package com.example.deportistas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDto {

    private String nombre;
    private String apellido;
    private String deporte;

}
