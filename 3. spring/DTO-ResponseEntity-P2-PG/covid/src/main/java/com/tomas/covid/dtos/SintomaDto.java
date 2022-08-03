package com.tomas.covid.dtos;

import com.tomas.covid.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDto {

    private Long codigo;
    private String Nombre;
    private String nivelGravedad;

}
