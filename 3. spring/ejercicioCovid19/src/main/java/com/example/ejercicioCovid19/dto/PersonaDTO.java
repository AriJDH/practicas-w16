package com.example.ejercicioCovid19.dto;

import com.example.ejercicioCovid19.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private String nombre;
    private String apellido;
}
