package com.bootcamp.elspersonas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;

    private String name;

    private String lastName;

    private String age;

    private String city;

    private String state;
}