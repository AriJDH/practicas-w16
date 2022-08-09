package com.bootcamp.be_java_hisp_w16_g04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer userId;
  private String userName;
}
