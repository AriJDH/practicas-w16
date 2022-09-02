package com.bootcamp.ejerciciovehiculossiniestros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestro {

    List<Vehiculo> vehiculo;
    Integer totaSiniestro;
}
