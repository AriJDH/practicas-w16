package com.example.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehiculo")
public class VehiculoBDDTO {
    private String patente;
    private String marca;
    private String modelo;
    private double perdida_Total;
}
