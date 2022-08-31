package com.ndemaio.ejerciciojoyeria.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jewelry {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int identifierNumber;

    private String name;
    private String material;
    private Double height;
    private String feature;
    private Boolean hasStone;
    private Boolean canBeSold;


}
