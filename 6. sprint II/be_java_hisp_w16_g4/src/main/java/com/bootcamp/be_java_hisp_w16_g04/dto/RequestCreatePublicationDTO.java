package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@GroupSequence({RequestCreatePublicationDTO.class, ProductCreateDTO.class})
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestCreatePublicationDTO {

  @NotNull(message = "El ID no puede estar vacio.")
  @Min(value = 1, message = "El ID deber ser mayor a cero.")
  private Integer userId;

  @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
  @NotNull(message = "la fecha no debe estar vacia")
  private LocalDate date;

  private @Valid ProductCreateDTO product;
  private Integer category;

  @NotNull(message = "El campo no debe estar vacio")
  @Max(value = 10000000)
  private double price;
}
