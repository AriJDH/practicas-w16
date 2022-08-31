package com.example.jpa.model;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
//@Table(name = "MiniSerie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rating;
    //@Column(name = "amount_of_awards")
    private int amountOfAwards;


}
