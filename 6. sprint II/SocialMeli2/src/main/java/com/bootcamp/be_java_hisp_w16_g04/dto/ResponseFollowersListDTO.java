package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseFollowersListDTO {
    private Integer userId;
    private String userName;
    List<User> followers;
}
