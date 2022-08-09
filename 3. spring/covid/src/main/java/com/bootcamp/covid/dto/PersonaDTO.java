package com.bootcamp.covid.dto;


import com.bootcamp.covid.model.Sintoma;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private List<Sintoma> sintomas;
}
