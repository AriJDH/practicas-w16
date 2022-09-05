package com.meli.seguroshql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sinisters")
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate date;

    private Double economicLoss;

    @ManyToOne
    @JoinColumn(name = "vahicle_id", nullable = false)
    private Vehicle vehicle;
}
