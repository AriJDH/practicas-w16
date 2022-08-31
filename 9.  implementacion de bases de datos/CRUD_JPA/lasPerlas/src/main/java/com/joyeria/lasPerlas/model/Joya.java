package com.joyeria.lasPerlas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long nro_identificatorio;
    String nombre;
    String material;
    Double gramos;
    String particularidad;
    Boolean posee_piedra;
    Boolean ventaONo;
}
