package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPublicationDTO {
  private Integer publicationId;
  private Integer userId;
  private LocalDate date;
  private Integer productId;
  private Integer category;
  private Double priceNormal;
  private Double priceDiscount;

  private Boolean hasPromo;
  private Double discount;


  public PromoPublicationDTO(Integer publicationId, Integer userId, LocalDate date, Integer productId, Integer category,Double discount, Boolean hasPromo,Double price) {
    this.publicationId = publicationId;
    this.userId = userId;
    this.date = date;
    this.productId = productId;
    this.category = category;
    this.discount = discount;
    this.hasPromo = hasPromo;
    this.priceDiscount = this.hasPromo? price - (price * getDiscount()) : price ;
    this.priceNormal = price;
  }


}