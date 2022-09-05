package com.meli.elasticsearch.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String id;

    private String name;

    private String lastName;

    private Integer age;

    private String city;

    private String province;

    private String department;

    private LocalDate date;
}
