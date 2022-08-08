package com.javaW16.linkTraker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Link {

   private Integer id;
   private String url;
   private Integer password;
   private Integer nVisits;

}
