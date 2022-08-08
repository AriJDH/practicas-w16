package com.javaW16.linkTraker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponseMetricsDTO {
   private String url;
   private Integer nVisits;
}
