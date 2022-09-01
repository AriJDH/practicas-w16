package com.example.qatesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter @Setter @Entity
public class TestCase {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_case;

    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate last_update;
}
