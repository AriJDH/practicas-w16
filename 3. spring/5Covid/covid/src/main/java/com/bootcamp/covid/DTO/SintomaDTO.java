package com.bootcamp.covid.DTO;

import com.bootcamp.covid.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

}
