package com.bootcamp.elastic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "employees")
public class Employee {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Field(type = FieldType.Date)
    private LocalDate fechaNacimiento;
}
