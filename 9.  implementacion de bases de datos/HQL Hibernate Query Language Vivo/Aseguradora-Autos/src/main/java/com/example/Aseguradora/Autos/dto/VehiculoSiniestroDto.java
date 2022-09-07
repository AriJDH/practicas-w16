package com.example.Aseguradora.Autos.dto;

import com.example.Aseguradora.Autos.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDto {
    private VehiculoPatenteMarcaModeloDto vehiculo;
    private Integer totalPerdidaSiniestro;
}
