package com.bootcamp.be_java_hisp_w16_g04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
  private Integer publicationId;
  private Integer userId;
  private LocalDate date;
  private Integer productId;
  private Integer category;
  private Double price;
}