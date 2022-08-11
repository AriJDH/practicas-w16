package com.deportistas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO implements Serializable{
    private String deporte;
    private String nombre;
    private String apellido;
}
