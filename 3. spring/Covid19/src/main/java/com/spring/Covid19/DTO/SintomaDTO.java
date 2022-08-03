package com.spring.Covid19.DTO;

import com.spring.Covid19.entities.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;

}
