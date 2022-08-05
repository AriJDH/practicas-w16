package com.CalculadoraCalorias.calorias.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatosDTO {

    private String name;
    private Integer gram;
    private List<String> ingredientes;
}

