package com.example.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelGravedad;
}
