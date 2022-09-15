package com.example.qatesters.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String description;
    @Column(nullable = false)
    private Boolean tested = false;
    @Column(nullable = false)
    private Boolean passed = false;
    @Column(nullable = false)
    private Integer numberOfTries= 0;
    @Column(nullable = false)
    private LocalDate lastUpdate = LocalDate.now();
}
