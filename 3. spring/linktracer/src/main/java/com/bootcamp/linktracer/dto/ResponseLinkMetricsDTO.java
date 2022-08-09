package com.bootcamp.linktracer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLinkMetricsDTO {
    private int id;
    private String url;
    private int numRedirects;
    private boolean isActive;
}
