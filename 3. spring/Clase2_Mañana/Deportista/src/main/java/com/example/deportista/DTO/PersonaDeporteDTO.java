package com.example.deportista.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeporteDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
