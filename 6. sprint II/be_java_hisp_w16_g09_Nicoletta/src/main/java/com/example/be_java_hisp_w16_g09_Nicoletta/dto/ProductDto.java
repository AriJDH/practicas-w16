package com.example.be_java_hisp_w16_g09_Nicoletta.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {
    @NotNull(message = "The productId cannot be empty.")
    @Min(value=1, message = "The productId must be greater than 0" )
    private int productId;
    @NotBlank(message = "The productName cannot be empty.")
    @Size(max = 40, message = "The length of the product name cannot exceed 40 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "The productName cannot contain special characters.")
    private String productName;
    @NotBlank(message = "The type cannot be empty.")
    @Size(max = 15, message = "The length of the product type cannot exceed 15 characters.")
    @Pattern(regexp="^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "The type cannot contain special characters.")
    private String type;
    @NotBlank(message = "The brand cannot be empty.")
    @Size(max = 25, message = "The length of the product brand cannot exceed 25 characters.")
    @Pattern(regexp="^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "The brand cannot contain special characters.")
    private String brand;
    @NotBlank(message = "The color cannot be empty.")
    @Size(max = 15, message = "The length of the product color cannot exceed 15 characters.")
    @Pattern(regexp="^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "The color cannot contain special characters.")
    private String color;
    @Size(max = 80, message = "The length of the product notes cannot exceed 80 characters.")
    @Pattern(regexp="^[a-zA-Z0-9.\\-\\/+=@_ ]*$", message = "The notes cannot contain special characters.")
    private String notes;
}
