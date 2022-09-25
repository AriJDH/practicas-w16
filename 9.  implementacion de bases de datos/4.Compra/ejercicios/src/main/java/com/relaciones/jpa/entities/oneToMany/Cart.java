package com.relaciones.jpa.entities.oneToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //RELACION UNO A MUCHOS (el ONE)
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;
}
