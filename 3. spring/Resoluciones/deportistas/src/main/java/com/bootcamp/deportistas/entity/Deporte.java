package com.bootcamp.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {

    private String nombre;
    private String nivel;
}
