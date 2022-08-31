package com.miniSeries.series.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class MiniSerie {

    @Id
    @GeneratedValue
    Long id;
    String name;
    Double rating;
    int amount_of_awards;
}
