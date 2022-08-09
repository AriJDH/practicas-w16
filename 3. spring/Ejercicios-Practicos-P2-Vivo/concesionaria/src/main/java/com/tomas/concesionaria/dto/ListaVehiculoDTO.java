package com.tomas.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListaVehiculoDTO {

    private List<VehiculoMenosServicioDTO> vehiculo;

}
