package com.bootcamp.be_java_hisp_w16_g7.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
