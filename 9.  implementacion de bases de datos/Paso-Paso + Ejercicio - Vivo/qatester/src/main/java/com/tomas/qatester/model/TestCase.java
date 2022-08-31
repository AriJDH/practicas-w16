package com.tomas.qatester.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_case")
    private Long id;
    @Column(length = 200)
    private String description;
    private boolean tested;
    private boolean passed;
    @Column(name="number_of_tries")
    private int numberOfTries;
    @Column(name="last_update")
    private LocalDate lastUpdate;

}
