package com.bootcamp.be_java_hisp_w16_g08.entiry;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
