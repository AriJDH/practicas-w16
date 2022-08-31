package com.example.miniseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MiniSerie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double rating;
    private int amount_of_awards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAmount_of_awards() {
        return amount_of_awards;
    }

    public void setAmount_of_awards(int amount_of_awards) {
        this.amount_of_awards = amount_of_awards;
    }
}
