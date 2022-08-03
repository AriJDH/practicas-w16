package com.spring.deportistas.DTOs;

import com.spring.deportistas.entities.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<DeporteDTO> deportes;

}
