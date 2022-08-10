package com.bootcamp.be_java_hisp_w16_g10.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostUserDTO extends PostResDTO{
    private String userName;

    public PostUserDTO(Integer userId, String postId, LocalDate date, ProductResDTO product, Integer category, Double price, String userName) {
        super(userId, postId, date, product, category, price);
        this.userName = userName;
    }
}
