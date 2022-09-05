package com.bootcamp.showroom.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clothes")
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double sellPrice;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
}
