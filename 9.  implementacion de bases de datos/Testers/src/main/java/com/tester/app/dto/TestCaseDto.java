package com.tester.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {


    private String description;

    private boolean tested;

    private boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonFormat(pattern="dd/MM/yyyy")
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
