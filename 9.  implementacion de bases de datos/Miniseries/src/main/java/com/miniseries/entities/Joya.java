package com.miniseries.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "joya")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean venta_o_no = true;


}
