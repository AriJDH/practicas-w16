package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoProductPostDto extends PromoPostDto{
    private int postId;

    public PromoProductPostDto(int userId, LocalDate date, ProductDto product, int category, double price, boolean hasPromo, double discount, int postId) {
        super(userId, date, product, category, price, hasPromo, discount);
        this.postId = postId;
    }
}
