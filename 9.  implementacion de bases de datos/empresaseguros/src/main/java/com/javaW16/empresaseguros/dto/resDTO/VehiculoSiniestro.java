package com.javaW16.empresaseguros.dto.resDTO;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VehiculoSiniestro
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class VehiculoSiniestro {

   private List<VehiculoPatenteMarcaModeloResDTO> vehiculoMatriculaMarcaModeloDTO;
   private Integer perdidaTotal;

}
