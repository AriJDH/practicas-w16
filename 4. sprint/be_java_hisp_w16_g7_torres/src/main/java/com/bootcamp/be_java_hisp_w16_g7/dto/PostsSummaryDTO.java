package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostsSummaryDTO {
    private int userId;
    private List<Integer> postsId;
    private int totalPostsAmount;
    private int promoPostsAmount;
    private double postsTotalValue;
    private LocalDate oldestPostDate;
    private LocalDate newestPostDate;
    private Object highestPricePost;
}
