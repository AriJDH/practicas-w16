package com.bootcamp.SocialMeli2.dto.response;

import com.bootcamp.SocialMeli2.dto.response.ResponseUserInformationDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {
    private int userId;
    private String userName;
    private List<ResponseUserInformationDto> followerList;
    private List<ResponseUserInformationDto>  followedList;
}
