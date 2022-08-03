package com.bootcamp.covidapi.dto;

import com.bootcamp.covidapi.models.Sintoma;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto implements Serializable {

    private String nombre;
    private String apellido;
        private List<Sintoma> sintomas;
}
