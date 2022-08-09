package com.bootcamp.be_java_hisp_w16_g01.dto;

import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowerDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followers;

}
