package com.example.qatesters.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TestCaseDTO {

    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate last_update;

}
