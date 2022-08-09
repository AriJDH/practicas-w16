package com.bootcamp.linktracker.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkMetricDTO {
    private String link;
    private Integer count;
}
