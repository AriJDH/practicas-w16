package com.ndemaio.ejercicioaseguradorahql.repository;

import com.ndemaio.ejercicioaseguradorahql.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {

    private Vehiculo vehiculo;
    private Double perdidaTotal;

}
