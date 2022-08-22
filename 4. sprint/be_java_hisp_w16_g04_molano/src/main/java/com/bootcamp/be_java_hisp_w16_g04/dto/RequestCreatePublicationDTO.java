package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestCreatePublicationDTO {
  @Max(value = 1, message = "El valor maximo es 1")
  @Min(value = -1, message = "El valor minimo es -1")
  private Integer userId;
  @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
  private LocalDate date;
  private ProductCreateDTO product;
  private Integer category;
  private double price;
  private Boolean hasPromo;
  private Double discount;
}
