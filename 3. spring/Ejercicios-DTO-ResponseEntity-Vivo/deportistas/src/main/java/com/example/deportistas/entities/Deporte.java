package com.example.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Deporte {

    private String nombre;
    private int nivel;

}
