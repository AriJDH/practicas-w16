package com.bootcamp.elsproductos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Long id;

    private String name;

    private String productType;

    private Double sellingPrice;

    private Double quantity;
}