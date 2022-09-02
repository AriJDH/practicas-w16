package com.bootcamp.ejerciciovehiculossiniestros.dto;

import com.bootcamp.ejerciciovehiculossiniestros.model.Vehiculo;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroDto {
    List<VehiculoMPMDto> vehiculo;
    Double totaSiniestro;
}
