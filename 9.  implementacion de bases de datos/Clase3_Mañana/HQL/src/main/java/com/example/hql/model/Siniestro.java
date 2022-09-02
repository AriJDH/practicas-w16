package com.example.hql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private double perdida_economica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "vehiculo_id")
    private Vehiculo vehiculo;

}
