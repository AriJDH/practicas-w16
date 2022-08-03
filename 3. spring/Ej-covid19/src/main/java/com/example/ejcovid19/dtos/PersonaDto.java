package com.example.ejcovid19.dtos;

import com.example.ejcovid19.entities.Persona;
import com.example.ejcovid19.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private Persona persona;
    private Sintoma sintoma;
}
