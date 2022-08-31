package com.javaW16.qatesters.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TestCase {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)

   private Long id_case;
   private String description;
   private Boolean tested;
   private Boolean passed;
   private int numbers_of_tries;
   private LocalDate last_update ;

}
