package com.bootcamp.testcase.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Builder
@Getter @Setter
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_update;

    public TestCase(){}

    public TestCase(Long id, String descripcion, Boolean tested, Boolean passed, Integer number_of_tries, LocalDate last_update) {
        this.id = id;
        this.descripcion = descripcion;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }
}
