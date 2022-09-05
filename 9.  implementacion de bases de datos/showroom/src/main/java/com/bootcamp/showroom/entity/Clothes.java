package com.bootcamp.showroom.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "clothes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Clothes {
    @Id
    private String id;
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer amount;
    private Double sellPrice;
}
