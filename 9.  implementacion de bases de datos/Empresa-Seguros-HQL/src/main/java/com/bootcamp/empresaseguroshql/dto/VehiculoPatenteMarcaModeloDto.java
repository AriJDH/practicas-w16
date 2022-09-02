package com.bootcamp.empresaseguroshql.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoPatenteMarcaModeloDto {

    private String patente;
    private String marca;
    private String modelo;
}
