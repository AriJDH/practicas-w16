package com.bootcamp.qatester.dto;

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

public class TestCaseDtoResponse {
    @JsonProperty(value = "id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty(value = "number_of_tries")
    private int numberOfTries;
    @JsonProperty(value = "last_update")
    private LocalDate lastUpdate;
}
