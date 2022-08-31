package com.example.qatesters.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE test_case SET deleted = true WHERE id_case=?")
@Where(clause = "deleted=false")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate last_update;
    private boolean deleted = Boolean.FALSE;

}
