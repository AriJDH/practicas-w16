package com.curso.item.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private Long id;
  private String name;
  private String description;
  private Double price;
  private Date createAt;
}
