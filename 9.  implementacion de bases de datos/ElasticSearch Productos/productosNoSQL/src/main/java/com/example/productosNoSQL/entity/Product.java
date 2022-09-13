package com.example.productosNoSQL.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String tipo;
    @JsonProperty("precio_venta")
    private Double precioVenta;
    @JsonProperty("precio_costo")
    private Double precioCosto;
    private Integer cantidad;
}
