package com.example.productosNoSQL.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

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
