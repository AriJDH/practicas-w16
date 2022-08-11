package com.meli.be_java_hisp_w16_g5.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Post {

    private int userId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
