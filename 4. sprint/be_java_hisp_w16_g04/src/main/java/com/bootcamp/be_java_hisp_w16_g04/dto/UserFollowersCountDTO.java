package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class UserFollowersCountDTO extends UserDTO {
  private Integer followersCount;

  public UserFollowersCountDTO(Integer userId, String userName, int size) {
    super(userId,userName);
    followersCount = size;
  }
}
