package com.example.testcase.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class TestCase {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_case;
    private String descripcion;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;

    public TestCase(Long id_case, String descripcion, Boolean tested, Boolean passed, int number_of_tries, LocalDate last_update) {
        this.id_case = id_case;
        this.descripcion = descripcion;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }

    public TestCase() {

    }
}
