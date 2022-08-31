package com.myapp.lasperlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="nro_identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name="posee_piedra")
    private Boolean poseePiedra;
    @Column(name="venta_o_no")
    private Boolean ventaONo=true;

}
