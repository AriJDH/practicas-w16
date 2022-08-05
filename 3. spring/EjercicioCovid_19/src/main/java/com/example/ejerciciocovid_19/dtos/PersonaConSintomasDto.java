package com.example.ejerciciocovid_19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaConSintomasDto {
    private String nombre;
    private String appellido;
    private List<String> listaSintomas;
}
