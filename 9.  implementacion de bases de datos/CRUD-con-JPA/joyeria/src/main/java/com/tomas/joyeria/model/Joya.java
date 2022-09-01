package com.tomas.joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
public class Joya {

    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long numeroId;

    @Column(length = 50)
    private String nombre;
    @Column(length = 40)
    private String material;
    @Column(precision = 5, scale = 2)
    private double peso;
    @Column(length = 100)
    private String particularidad;
    @Column(name="posee_piedra")
    @Type(type="boolean")
    private boolean poseePiedra;
    @Column(name="venta_o_no")
    @Type(type="boolean")
    private boolean ventaONo;


}
