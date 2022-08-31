package com.example.ejerciciodosvivo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    Integer numberOfTries;
    LocalDate lastUpdate;
}
