package com.ejemplo.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private Integer edad;

}
