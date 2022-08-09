package com.example.be_java_hisp_w16_g09.dto;

import com.example.be_java_hisp_w16_g09.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//Response
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RecentPostsDTO {

    private int userId;
    private List<PostDto> posts;

}
