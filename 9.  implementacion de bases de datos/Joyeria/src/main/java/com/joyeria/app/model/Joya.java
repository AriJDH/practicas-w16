package com.joyeria.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String material;

    @Column
    private Double peso;

    @Column
    private String particularidad;

    @Column
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;

    @Column
    private boolean ventaONo;




}
