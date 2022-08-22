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
public class PostLastTwoWeeksDto extends PostDto{
    private int postId;
    public PostLastTwoWeeksDto(int postId, int userId, LocalDate date, ProductDto product, int category, double price) {
        super(userId, date, product, category, price);
        this.postId = postId;
    }
}
