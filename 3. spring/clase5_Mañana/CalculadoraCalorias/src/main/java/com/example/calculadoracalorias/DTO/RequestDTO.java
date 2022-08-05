package com.example.calculadoracalorias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String name;
    private List<String> ingredientes;
    private Integer peso;
}
