package com.meli.consigna.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    @JsonFormat(pattern="dd/MM/yyyy")
    @JsonProperty
    private LocalDate lastUpdate;
}
