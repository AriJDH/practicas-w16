package com.example.qatestersexercice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertTestCaseDto {
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;

    //@JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    LocalDate last_update;
}
