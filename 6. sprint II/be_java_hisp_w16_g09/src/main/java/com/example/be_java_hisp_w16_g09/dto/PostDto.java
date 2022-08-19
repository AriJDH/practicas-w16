package com.example.be_java_hisp_w16_g09.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {
    @NotNull(message = "The user_id cannot be empty.")
    @Min(value=1, message = "The user_id must be greater than 0" )
    private int userId;
    //@NotNull(message = "The postId cannot be empty.")
    //@Min(value=1, message = "The postId must be greater than 0" )
    private int postId;
    @NotNull(message = "The date cannot be empty.")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private @Valid ProductDto product;
    private int categoryId;
    @DecimalMax(value = "10000000", message = "Max price 10000000")
    private double price;
}