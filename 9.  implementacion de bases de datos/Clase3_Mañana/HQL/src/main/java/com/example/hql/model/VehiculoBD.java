package com.example.hql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vehiculo")
public class VehiculoBD {
    private String patente;
    private String marca;
    private String modelo;
    private double perdida_Total;
}
