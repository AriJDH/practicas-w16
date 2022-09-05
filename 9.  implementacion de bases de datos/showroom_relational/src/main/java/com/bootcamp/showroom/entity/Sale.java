package com.bootcamp.showroom.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long number;
    private LocalDate date;
    private Double total;
    private String paymentType;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Clothes> clothes;
}
