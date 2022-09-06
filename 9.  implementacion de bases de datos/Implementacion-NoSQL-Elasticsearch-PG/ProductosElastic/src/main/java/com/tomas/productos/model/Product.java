package com.tomas.productos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "products_data")
public class Product {

    @Id
    private String id;
    private String name;
    private String type;
    private Double priceSale;
    private Double priceCost;
    private Integer amount;


}
