package com.example.miniseries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class MiniSerie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double rating;
    private Integer amount_of_awards;
}
