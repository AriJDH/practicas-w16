package com.bootcamp.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePatenteMarcaDTO {
    private String patente;
    private String marca;
}
