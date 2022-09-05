package com.bootcamp.productos.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "productos")
public class Producto {

    @Id
    private String id;

    private String nombre;

    private String tipo;

    private Double precio;

    private Double precioProduccion;

    private Integer cantidadDisponible;

    public Producto(String nombre, String tipo, Double precio, Double precioProduccion, Integer cantidadDisponible) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.precioProduccion = precioProduccion;
        this.cantidadDisponible = cantidadDisponible;
    }
}
