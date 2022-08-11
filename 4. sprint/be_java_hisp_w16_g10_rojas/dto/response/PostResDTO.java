package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResDTO {
   private Integer userId;
   private Integer postId;
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private LocalDate date;
   private ProductResDTO product;
   private Integer category;
   private Double price;
   private Boolean hasPromo;
   private Double discount;
}
