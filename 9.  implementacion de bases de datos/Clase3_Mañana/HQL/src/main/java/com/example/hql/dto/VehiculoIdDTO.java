package com.example.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoIdDTO {
    private int id;
    private String patente;
    private String marca;
    private String modelo;
    private String anio_fabricacion;
    private int cantidad_ruedas;
}