package com.example.ejerciciosiniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerdidasTotalDTO {
    private List<VehiculoDTO> vehiculos;
    private Double totalPerdidas;
}
