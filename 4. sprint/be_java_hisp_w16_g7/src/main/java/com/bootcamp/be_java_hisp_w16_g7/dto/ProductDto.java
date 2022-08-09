package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
