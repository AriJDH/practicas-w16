package com.miniseries.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "Miniserie")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double rating;
    private int amount_of_awards;
}
