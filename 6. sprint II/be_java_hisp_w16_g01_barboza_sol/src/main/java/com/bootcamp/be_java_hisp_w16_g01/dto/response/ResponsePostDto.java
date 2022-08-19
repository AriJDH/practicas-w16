package com.bootcamp.be_java_hisp_w16_g01.dto.response;

import com.bootcamp.be_java_hisp_w16_g01.dto.request.ProductDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponsePostDto {

    private int userId;

    private int postId;

    private LocalDate date;

    private ProductDto product;

    private int category;

    private double price;
}
