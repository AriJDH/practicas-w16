package com.elastic.literarywork.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "literarywork")
public class LiteraryWork {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Integer)
    private Integer amountPages;
    @Field(type = FieldType.Text)
    private String publisher;
    @Field(type = FieldType.Date)
    private LocalDate yearPublication;
}
