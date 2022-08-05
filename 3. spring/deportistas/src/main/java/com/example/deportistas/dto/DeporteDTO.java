package com.example.deportistas.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeporteDTO implements Serializable {

    private String nombre;
    private String nivel;

}
