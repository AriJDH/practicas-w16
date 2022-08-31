package com.example.testcase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseIdDTO {
    private long id;
    private String description;
    private boolean tested;
    private boolean passed;
    private int number_of_tries;
    private LocalDate last_update;
}
