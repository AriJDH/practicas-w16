package com.tomas.miniseries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Miniserie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;

}
