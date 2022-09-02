package com.example.hql.dto;

import com.example.hql.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    private String anio_fabricacion;
    private int cantidad_ruedas;
}