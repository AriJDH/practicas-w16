package com.elastic.employees.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employees")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Employee {
    // id, nombre, apellido, edad, ciudad y provincia/estado/departamento
    @Id
    private String id;
    private String name;
    private String lastname;
    private Integer age;
    private String city;
    private String department;
}
