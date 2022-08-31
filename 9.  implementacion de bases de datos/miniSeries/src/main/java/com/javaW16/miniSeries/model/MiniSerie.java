package com.javaW16.miniSeries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class MiniSerie {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   Long id;   

   String name;
   Double rating;
   int amount_of_awards;

}
