package com.example.testers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long idCase;
  private String description;
  private Boolean tested;
  private Boolean passed;
  private int numberOfTries;
  private LocalDate lastUpdate;
}
