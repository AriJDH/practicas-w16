package com.bootcamp.miniseries.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Miniserie {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    Double rating;
    int amountOfAwards;
}
