package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PublicationCreateDTO {
  private Integer userId;
  private LocalDate date;
  private Integer category;
  private Double discount;
  private Double price;
  private Integer productId;
  private Boolean hasPromo;

}
