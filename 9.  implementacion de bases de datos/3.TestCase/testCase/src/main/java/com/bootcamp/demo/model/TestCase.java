package com.bootcamp.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="testcase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_case")
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name="number_of_tries")
    private int numberOfTries;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="last_update")
    private LocalDate lastUpdate;
}
