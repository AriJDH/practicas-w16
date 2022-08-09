package com.bootcamp.be_java_hisp_w16_g04.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follower {
  private Integer idUser;
  private Integer idFollower;
}
