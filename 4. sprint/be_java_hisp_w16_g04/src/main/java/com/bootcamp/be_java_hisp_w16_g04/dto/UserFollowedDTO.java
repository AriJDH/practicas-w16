package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class UserFollowedDTO extends UserDTO {
  List<User> followed;
}
