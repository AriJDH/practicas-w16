package com.bootcamp.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;
  private long kilometers;
  private String description;
}
