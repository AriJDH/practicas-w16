package com.example.ejerciciocovid_19.entities;


import com.example.ejerciciocovid_19.Enums.NivelGravedad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private NivelGravedad nivel_de_gravedad;
}
