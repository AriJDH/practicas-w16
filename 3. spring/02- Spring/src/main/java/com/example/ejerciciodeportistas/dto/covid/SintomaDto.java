package com.example.ejerciciodeportistas.dto.covid;

import com.example.ejerciciodeportistas.entities.covid.Sintoma;
import com.example.ejerciciodeportistas.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDto {
    private String codigo;
    private String nombre;
    private String nivelGravedad;
}
