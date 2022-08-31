package com.example.testcase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_case;
    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private LocalDate last_update;
}
