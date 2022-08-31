package com.example.miniserie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double rating;
    private int amount_of_awards;
}
