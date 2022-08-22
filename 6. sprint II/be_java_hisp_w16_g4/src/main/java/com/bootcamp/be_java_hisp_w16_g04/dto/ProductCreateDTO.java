package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductCreateDTO {

  //"^([-_ a-zA-Z0-9]+(\\/{1}[a-zA-Z0-9]+)*)+(?!([\\/]{2}))$"
  //"^((?=[A-Za-z0-9@])(?![_\\\\-]).)*$"
  private final String validationRegexp = "^([-_ a-zA-Z0-9]+(\\/{1}[a-zA-Z0-9]+)*)+(?!([\\/]{2}))$";


  @NotNull(message = "El ID no puede estar vacio.")
  @Min(value = 1, message = "El ID deber ser mayor a cero.")
  private Integer productId;

  @Pattern(regexp = validationRegexp, message = "El campo no puede contener caracteres especiales.")
  @Size(max= 40, message = "La longitud no puede superar los 40 caracteres")
  @NotEmpty(message = "El campo no puede estar vacio")
  private String productName;

  @Pattern(regexp = validationRegexp, message = "El campo no puede contener caracteres especiales.")
  @Size(max= 15, message = "La longitud no puede superar los 15 caracteres")
  @NotEmpty(message = "El campo no puede estar vacio")
  private String type;

  @Pattern(regexp = validationRegexp, message = "El campo no puede contener caracteres especiales.")
  @Size(max= 25, message = "La longitud no puede superar los 25 caracteres")
  @NotEmpty(message = "El campo no puede estar vacio")
  private String brand;

  @Pattern(regexp = validationRegexp, message = "El campo no puede contener caracteres especiales.")
  @Size(max= 15, message = "La longitud no puede superar los 15 caracteres")
  @NotEmpty(message = "El campo no puede estar vacio")
  private String color;

  @Pattern(regexp = validationRegexp, message = "El campo no puede contener caracteres especiales.")
  @Size(max= 80, message = "La longitud no puede superar los 80 caracteres")
  private String notes;
}
