package com.example.ejemplorelaciones.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="cart")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany(mappedBy = "pepe", cascade= {CascadeType.REMOVE, CascadeType.PERSIST})
    private Set<Item> items;
}
