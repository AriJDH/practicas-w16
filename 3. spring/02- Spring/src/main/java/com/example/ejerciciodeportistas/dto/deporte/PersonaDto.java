package com.example.ejerciciodeportistas.dto.deporte;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {

    private String nombre;
    private String apellido;
    private String nombreDeporte;

}
