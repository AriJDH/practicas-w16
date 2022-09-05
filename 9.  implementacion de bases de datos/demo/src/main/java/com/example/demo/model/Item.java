package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

}
