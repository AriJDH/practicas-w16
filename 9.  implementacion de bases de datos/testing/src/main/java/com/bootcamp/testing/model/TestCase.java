package com.bootcamp.testing.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idCase;
    private String description;
    private Boolean tested;
    private int numberOfTries;
    private LocalDate lastUpdate;

}
