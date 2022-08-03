package com.grodriguez.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;
}
