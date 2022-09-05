package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;

}
