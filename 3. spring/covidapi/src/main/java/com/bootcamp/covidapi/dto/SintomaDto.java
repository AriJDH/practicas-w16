package com.bootcamp.covidapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDto {
    private String codigo;
    private String nombre;
    private String NIVEL_DE_GRAVEDAD;
}
