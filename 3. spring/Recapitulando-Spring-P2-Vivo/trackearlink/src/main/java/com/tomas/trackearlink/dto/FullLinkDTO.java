package com.tomas.trackearlink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullLinkDTO {
    private int id;
    private String url;
    private int redirectsCounter;
}
