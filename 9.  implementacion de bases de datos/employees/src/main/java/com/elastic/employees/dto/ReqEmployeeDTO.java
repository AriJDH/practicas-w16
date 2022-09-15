package com.elastic.employees.dto;

import lombok.Data;

@Data
public class ReqEmployeeDTO {
    private String name;
    private String lastname;
    private Integer age;
    private String city;
    private String department;
}

