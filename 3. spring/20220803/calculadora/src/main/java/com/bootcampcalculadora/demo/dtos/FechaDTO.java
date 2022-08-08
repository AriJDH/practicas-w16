package com.bootcampcalculadora.demo.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class FechaDTO {

    private int dia;
    private int mes;
    private int anio;
}
