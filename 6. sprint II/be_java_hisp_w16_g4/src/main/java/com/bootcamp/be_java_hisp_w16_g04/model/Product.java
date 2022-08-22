package com.bootcamp.be_java_hisp_w16_g04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private Integer productId;
  private String productName;
  private String type;
  private String brand;
  private String color;
  private String notes;
}
