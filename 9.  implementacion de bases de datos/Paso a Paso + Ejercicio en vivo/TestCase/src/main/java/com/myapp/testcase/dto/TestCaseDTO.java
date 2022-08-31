package com.myapp.testcase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate last_update;
}
