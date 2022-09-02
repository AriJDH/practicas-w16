package com.vehiculos.seguro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoTotalPerdidaDTO extends PatenteModeloMarcaDTO{

    double perdidaTotal;

}
