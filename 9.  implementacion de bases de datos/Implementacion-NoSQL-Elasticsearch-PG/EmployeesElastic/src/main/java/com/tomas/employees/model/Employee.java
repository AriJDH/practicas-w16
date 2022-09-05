package com.tomas.employees.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employee_data")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String state;

}
