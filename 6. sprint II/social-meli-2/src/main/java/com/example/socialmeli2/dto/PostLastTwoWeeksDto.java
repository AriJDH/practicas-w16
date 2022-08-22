package com.example.socialmeli2.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostLastTwoWeeksDto extends PostDto{
    private int postId;

    public PostLastTwoWeeksDto(int userId, LocalDate date, ProductDto product, int category, double price) {
        super(userId, date, product, category, price);
    }

    public PostLastTwoWeeksDto(){
        super();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
