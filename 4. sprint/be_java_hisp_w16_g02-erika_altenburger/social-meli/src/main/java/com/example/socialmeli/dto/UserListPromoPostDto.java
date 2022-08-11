package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserListPromoPostDto extends UserDto{
    private List<PromoProductPostDto> posts;

    public UserListPromoPostDto(Integer userId, String userName, List<PromoProductPostDto> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
