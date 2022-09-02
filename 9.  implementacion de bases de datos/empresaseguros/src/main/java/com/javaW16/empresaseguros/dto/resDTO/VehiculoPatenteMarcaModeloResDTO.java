package com.javaW16.empresaseguros.dto.resDTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VehiculoMatriculaMarcaModeloResDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder

public class VehiculoPatenteMarcaModeloResDTO {

   String patente;
   String marca;
   String modelo;

}
