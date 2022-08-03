package com.bootcamp.covidapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Sintoma implements Serializable {

    @JsonIgnore
    private String codigo;
    private String nombre;
    private String NIVEL_DE_GRAVEDAD;


}
