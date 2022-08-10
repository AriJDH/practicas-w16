package com.bootcamp.be_java_hisp_w16_g08.dto.response;

import com.bootcamp.be_java_hisp_w16_g08.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponsePostDto {
    private int postId;
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private ResponseProductDto product;
    private double price;
    private int category;
}
