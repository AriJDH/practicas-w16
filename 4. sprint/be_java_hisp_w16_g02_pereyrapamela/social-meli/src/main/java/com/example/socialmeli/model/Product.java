package com.example.socialmeli.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
