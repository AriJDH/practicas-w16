package com.tester.app.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id_case")
    private Long idCase;
    @Column
    private String description;

    @Column
    private boolean tested;

    @Column
    private boolean passed;

    @Column
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    public boolean wasPublishedAfter(LocalDate aDate) {
        return lastUpdate.isAfter(aDate);
    }
}
