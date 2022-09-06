package com.example.lasPerlas.entity;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "joya")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_identificatorio;

    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo = true;


}
